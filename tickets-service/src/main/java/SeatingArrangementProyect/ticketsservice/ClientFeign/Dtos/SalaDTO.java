package SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaDTO {
    Integer nroSala;
    String nombreEstadoSala;
    String nombreTipoSala;
    Integer filas;
    Integer columnas;
}
