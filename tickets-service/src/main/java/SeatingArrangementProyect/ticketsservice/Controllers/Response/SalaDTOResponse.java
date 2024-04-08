package SeatingArrangementProyect.ticketsservice.Controllers.Response;

import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.SalaDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaDTOResponse {
    Integer nroSala;
    String nombreEstadoSala;
    String nombreTipoSala;

    public static SalaDTOResponse from(SalaDTO dto){
        return SalaDTOResponse.builder()
                .nroSala(dto.getNroSala())
                .nombreEstadoSala(dto.getNombreEstadoSala())
                .nombreTipoSala(dto.getNombreTipoSala())
                .build();
    }
}
