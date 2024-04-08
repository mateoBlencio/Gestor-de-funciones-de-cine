package SeatingArrangementProyect.ticketsservice.ClientFeign;

import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.FuncionDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuncionesFeignService {
    final FuncionFeign funcionFeign;

    public List<FuncionDto> getFunciones(){
        return funcionFeign.getAllFunciones().getBody();
    }

    public FuncionDto getFuncion(Long funcionId){
        return funcionFeign.getOne(funcionId).getBody();
    }

    public List<FuncionDto> getFuncionesActuales(){
        return funcionFeign.getFuncionesActuales().getBody();
    }


}
