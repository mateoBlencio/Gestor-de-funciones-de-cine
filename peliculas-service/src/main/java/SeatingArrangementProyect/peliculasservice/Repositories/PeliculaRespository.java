package SeatingArrangementProyect.peliculasservice.Repositories;

import SeatingArrangementProyect.peliculasservice.Model.EstadoPeliculaBD;
import SeatingArrangementProyect.peliculasservice.Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRespository extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findPeliculasByEstadoPeliculaBD_Nombre(String nombreEstadoPelicula);
}
