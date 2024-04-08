package SeatingArrangementProyect.peliculasservice.Repositories;

import SeatingArrangementProyect.peliculasservice.Model.CategoriaPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CategoriaPeliculaRepository extends JpaRepository<CategoriaPelicula, Integer> {
    Optional<CategoriaPelicula> findCategoriaPeliculaByNombre(String nombre);
}
