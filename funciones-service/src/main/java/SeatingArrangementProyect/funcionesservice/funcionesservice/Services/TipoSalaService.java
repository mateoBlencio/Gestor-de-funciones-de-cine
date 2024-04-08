package SeatingArrangementProyect.funcionesservice.funcionesservice.Services;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.TipoSala;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories.TipoSalaRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TipoSalaService {
    final TipoSalaRepository tipoSalaRepository;

    public List<TipoSala> getAll(){
        return tipoSalaRepository.findAll();
    }

    @Transactional
    public TipoSala create(String nombreTipoSala){
        TipoSala tipoSala = new TipoSala(nombreTipoSala);
        return tipoSalaRepository.save(tipoSala);
    }

    @Transactional
    public void deleteOne(Integer tipoSalaId){
        TipoSala tipoSala = tipoSalaRepository.findById(tipoSalaId)
                .orElseThrow(()-> new IllegalArgumentException("Tipo sala not found"));
        tipoSalaRepository.delete(tipoSala);
    }

    @Transactional
    public void update(Integer tipoSalaId, String nombreTipoSala){
        TipoSala tipoSala = tipoSalaRepository.findById(tipoSalaId)
                .orElseThrow(()-> new IllegalArgumentException("Tipo sala not found"));

        tipoSala.update(nombreTipoSala);
        tipoSalaRepository.save(tipoSala);
    }

}
