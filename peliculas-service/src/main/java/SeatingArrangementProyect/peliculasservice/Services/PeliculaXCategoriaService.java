package SeatingArrangementProyect.peliculasservice.Services;

import SeatingArrangementProyect.peliculasservice.Model.CategoriaPelicula;
import SeatingArrangementProyect.peliculasservice.Model.PeliculaXCategoria;
import SeatingArrangementProyect.peliculasservice.Repositories.CategoriaPeliculaRepository;
import SeatingArrangementProyect.peliculasservice.Repositories.PeliculaRespository;
import SeatingArrangementProyect.peliculasservice.Repositories.PeliculaXCategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeliculaXCategoriaService {
    final PeliculaXCategoriaRepository peliculaXCategoriaRepository;
    final PeliculaRespository peliculaRespository;
    final CategoriaPeliculaRepository categoriaRepository;

    public Set<CategoriaPelicula> getCategoriasXPelicula(Long id){
        val pelicula = peliculaRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Pelicula not found"));

        List<PeliculaXCategoria> peliculasXCategorias = peliculaXCategoriaRepository.findAllByPeliculaXCategoriaId_Pelicula(pelicula);

        Set<CategoriaPelicula> categorias = new HashSet<>();
        peliculasXCategorias.forEach(peliculaXCategoria -> categorias.add(peliculaXCategoria.getPeliculaXCategoriaId().getCategoriaPelicula()));
        return categorias;
    }

    @Transactional
    protected void create(Long peliculaId, String nombreCategoria){
        val pelicula = peliculaRespository.findById(peliculaId)
                .orElseThrow(()-> new IllegalArgumentException("Pelicula not found"));

        val categoria = categoriaRepository.findCategoriaPeliculaByNombre(nombreCategoria)
                .orElseThrow(()-> new IllegalArgumentException("Categoria not found"));

        PeliculaXCategoria peliculaXcategoria = new PeliculaXCategoria(pelicula, categoria);

        peliculaXCategoriaRepository.save(peliculaXcategoria);
    }

    @Transactional
    public void saveCategoriasPelicula(Long peliculaId, Set<String> nombresCategorias){
        for(String nombreCategoria : nombresCategorias){
            create(peliculaId, nombreCategoria);
        }
    }

    @Transactional
    public void eliminarCategoriasPelicula(Long id){
        val pelicula = peliculaRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Pelicula not found"));
        peliculaXCategoriaRepository.deleteAllByPeliculaXCategoriaId_Pelicula(pelicula);
    }
}
