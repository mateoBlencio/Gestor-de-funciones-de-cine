package SeatingArrangementProyect.peliculasservice.Repositories;

import SeatingArrangementProyect.peliculasservice.Model.CategoriaPelicula;
import SeatingArrangementProyect.peliculasservice.Model.Pelicula;
import SeatingArrangementProyect.peliculasservice.Model.PeliculaXCategoria;
import SeatingArrangementProyect.peliculasservice.Model.PeliculaXCategoriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaXCategoriaRepository extends JpaRepository<PeliculaXCategoria, PeliculaXCategoriaId> {

    List<PeliculaXCategoria> findAllByPeliculaXCategoriaId_Pelicula(Pelicula pelicula);

    List<PeliculaXCategoria> findAllByPeliculaXCategoriaId_CategoriaPelicula(CategoriaPelicula categoria);

    void deleteAllByPeliculaXCategoriaId_Pelicula(Pelicula pelicula);

    void deleteAllByPeliculaXCategoriaId_CategoriaPelicula(CategoriaPelicula categoria);
}
