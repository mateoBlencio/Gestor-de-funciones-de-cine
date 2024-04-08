package SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Funcion;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {

    List<Funcion> findFuncionsBySalaAndFechaFuncion(Sala sala, LocalDate fechaFuncion);
}
