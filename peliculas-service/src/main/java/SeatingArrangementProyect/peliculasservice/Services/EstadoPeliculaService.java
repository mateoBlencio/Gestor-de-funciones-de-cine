package SeatingArrangementProyect.peliculasservice.Services;

import SeatingArrangementProyect.peliculasservice.Model.EstadoPeliculaBD;
import SeatingArrangementProyect.peliculasservice.Repositories.EstadoPeliculaRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EstadoPeliculaService {
    final EstadoPeliculaRepository estadoRepository;

    public List<EstadoPeliculaBD> getAll(){
        return estadoRepository.findAll();
    }

    @Transactional
    public EstadoPeliculaBD create(String nombreP){
        EstadoPeliculaBD estadoPelicula = new EstadoPeliculaBD(nombreP);
        return estadoRepository.save(estadoPelicula);
    }

    @Transactional
    public void deleteOne(Integer id){
        EstadoPeliculaBD estadoPelicula = estadoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Estado not found"));

        estadoRepository.delete(estadoPelicula);
    }

    @Transactional
    public void update(Integer id, String nombreP){
        EstadoPeliculaBD estadoPelicula = estadoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Estado not found"));
        estadoPelicula.update(nombreP);
        estadoRepository.save(estadoPelicula);
    }
}
