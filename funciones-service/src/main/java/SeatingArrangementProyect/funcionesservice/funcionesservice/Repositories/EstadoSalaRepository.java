package SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.EstadoSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoSalaRepository extends JpaRepository<EstadoSala, Integer> {
}
