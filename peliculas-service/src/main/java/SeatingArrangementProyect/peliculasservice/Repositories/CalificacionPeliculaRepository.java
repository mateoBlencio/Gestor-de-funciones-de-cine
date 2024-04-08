package SeatingArrangementProyect.peliculasservice.Repositories;

import SeatingArrangementProyect.peliculasservice.Model.CalificacionPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionPeliculaRepository extends JpaRepository<CalificacionPelicula, Integer> {
}
