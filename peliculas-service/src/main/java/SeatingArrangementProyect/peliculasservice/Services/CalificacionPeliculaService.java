package SeatingArrangementProyect.peliculasservice.Services;

import SeatingArrangementProyect.peliculasservice.Repositories.CalificacionPeliculaRepository;
import SeatingArrangementProyect.peliculasservice.Model.CalificacionPelicula;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalificacionPeliculaService {
    final CalificacionPeliculaRepository calificacionRepository;

    public List<CalificacionPelicula> getAll(){
        return calificacionRepository.findAll();
    }

    @Transactional
    public CalificacionPelicula create(String nombreP, String descripcionP){
        CalificacionPelicula calificacionPelicula = new CalificacionPelicula(nombreP, descripcionP);
        return calificacionRepository.save(calificacionPelicula);
    }

    @Transactional
    public void deleteOne(Integer id){
        CalificacionPelicula calificacionPelicula = calificacionRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Calificacion not found"));

        calificacionRepository.delete(calificacionPelicula);
    }

    @Transactional
    public void update(Integer id, String nombreP, String descripcionP){
        CalificacionPelicula calificacionPelicula = calificacionRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Calificacion not found"));

        if (noExisteCalificacion(nombreP)){
            calificacionPelicula.update(nombreP, descripcionP);
            calificacionRepository.save(calificacionPelicula);
        }
        throw new IllegalArgumentException("No se actualizo calificacion");
    }

    private boolean noExisteCalificacion(String nombreCalificacion){
        List<CalificacionPelicula> todasCalificaciones = calificacionRepository.findAll();
       for (CalificacionPelicula calificacionPelicula : todasCalificaciones){
           if (Objects.equals(nombreCalificacion, calificacionPelicula.getNombre())){
               return false;
           }
       }
        return true;
    }
}
