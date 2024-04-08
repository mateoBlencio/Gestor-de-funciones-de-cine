package SeatingArrangementProyect.peliculasservice.Controllers.Requests;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCalificacionRequest {
    @NotNull
    String nombre;
    @NotNull
    String descripcion;
}
