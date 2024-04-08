package SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEstadoSalaRequest {
    @NotNull
    String nombre;
    @NotNull
    String descripcion;
}
