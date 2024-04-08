package SeatingArrangementProyect.peliculasservice.Repositories;

import SeatingArrangementProyect.peliculasservice.Model.EstadoPeliculaBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPeliculaRepository extends JpaRepository<EstadoPeliculaBD, Integer> {
}
