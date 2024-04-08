package SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateSalaRequest {
    @NotNull
    Integer nroEstado;
    @NotNull
    Integer tipoSala;
    @NotNull
    Integer filas;
    @NotNull
    Integer columnas;
}

