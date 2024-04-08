package SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
