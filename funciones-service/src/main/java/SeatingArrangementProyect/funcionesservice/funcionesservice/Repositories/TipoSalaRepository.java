package SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.TipoSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSalaRepository extends JpaRepository<TipoSala, Integer> {
}
