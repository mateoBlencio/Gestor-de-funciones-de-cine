package SeatingArrangementProyect.funcionesservice.funcionesservice.Services;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Sala;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories.EstadoSalaRepository;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories.SalaRepository;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories.TipoSalaRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaService {
    final SalaRepository salaRepository;
    final EstadoSalaRepository estadoSalaRepository;
    final TipoSalaRepository tipoSalaRepository;

    public List<Sala> getAll(){return salaRepository.findAll();}

    @Transactional
    public Sala create(Integer nroTipoSala, Integer filasP, Integer columnasP){
        val estadoSala = estadoSalaRepository.findById(1)
                .orElseThrow(()-> new IllegalArgumentException("Estado not found"));

        val tipoSala = tipoSalaRepository.findById(nroTipoSala)
                .orElseThrow(()-> new IllegalArgumentException("Tipo Sala not found"));

        Sala sala = new Sala(estadoSala, tipoSala, filasP, columnasP);
        return salaRepository.save(sala);
    }

    @Transactional
    public void deleteOne(Integer salaId){
        Sala sala = salaRepository.findById(salaId)
                .orElseThrow(()-> new IllegalArgumentException("Sala not found"));

        salaRepository.delete(sala);
    }

    @Transactional
    public void update(Integer salaId, Integer nroEstadoSala, Integer nroTipoSala, Integer filasP, Integer columnasP){
        Sala sala = salaRepository.findById(salaId)
                .orElseThrow(()-> new IllegalArgumentException("Sala not found"));

        val estadoSala = estadoSalaRepository.findById(nroEstadoSala)
                .orElseThrow(()-> new IllegalArgumentException("Estado not found"));

        val tipoSala = tipoSalaRepository.findById(nroTipoSala)
                .orElseThrow(()-> new IllegalArgumentException("Tipo Sala not found"));

        sala.update(estadoSala, tipoSala, filasP, columnasP);
        salaRepository.save(sala);
    }


}
