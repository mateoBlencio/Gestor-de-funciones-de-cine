package SeatingArrangementProyect.funcionesservice.funcionesservice.Responses;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Sala;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class SalaResponse {
    Integer nroSala;
    String nombreEstadoSala;
    String nombreTipoSala;
    Integer filas;
    Integer columnas;

    public static SalaResponse from(Sala aSala){
        return SalaResponse.builder()
                .nroSala(aSala.getNroSala())
                .nombreEstadoSala(aSala.getEstadoSala().getNombre())
                .nombreTipoSala(aSala.getTipoSala().getNombre())
                .filas(aSala.getFilas())
                .columnas(aSala.getColumnas())
                .build();
    }
}
