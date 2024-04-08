package SeatingArrangementProyect.funcionesservice.funcionesservice.Services;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.EstadoSala;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories.EstadoSalaRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EstadoSalaService {
    final EstadoSalaRepository estadoSalaRepository;

    public List<EstadoSala> getAll(){
        return estadoSalaRepository.findAll();
    }

    @Transactional
    public EstadoSala create(String nombreEstado, String descripcionEstado){
        EstadoSala estado = new EstadoSala(nombreEstado, descripcionEstado);
        return estadoSalaRepository.save(estado);
    }

    @Transactional
    public void deleteOne(Integer estadoId){
        EstadoSala estado = estadoSalaRepository.findById(estadoId)
                .orElseThrow(()-> new IllegalArgumentException("Estado not found"));

        estadoSalaRepository.delete(estado);
    }

    @Transactional
    public void update(Integer estadoId, String nombreEstado, String descripcionEstado){
        EstadoSala estado = estadoSalaRepository.findById(estadoId)
                .orElseThrow(()-> new IllegalArgumentException("Estado not found"));

        estado.update(nombreEstado, descripcionEstado);
        estadoSalaRepository.save(estado);
    }
}
