package SeatingArrangementProyect.peliculasservice.Services;

import SeatingArrangementProyect.peliculasservice.Model.CalificacionPelicula;
import SeatingArrangementProyect.peliculasservice.Model.CategoriaPelicula;
import SeatingArrangementProyect.peliculasservice.Repositories.CategoriaPeliculaRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoriaPeliculaService {
    final CategoriaPeliculaRepository categoriaRepository;

    public List<CategoriaPelicula> getAll(){
        return categoriaRepository.findAll();
    }

    @Transactional
    public CategoriaPelicula create(String nombreP){
        CategoriaPelicula categoriaPelicula = new CategoriaPelicula(nombreP);
        return categoriaRepository.save(categoriaPelicula);
    }

    @Transactional
    public void deleteOne(Integer id){
        CategoriaPelicula categoriaPelicula = categoriaRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Categoria not found"));

        categoriaRepository.delete(categoriaPelicula);
    }

    @Transactional
    public void update(Integer id, String nombreP){
        CategoriaPelicula categoriaPelicula = categoriaRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Categoria not found"));

        categoriaPelicula.update(nombreP);

        categoriaRepository.save(categoriaPelicula);
    }
}
