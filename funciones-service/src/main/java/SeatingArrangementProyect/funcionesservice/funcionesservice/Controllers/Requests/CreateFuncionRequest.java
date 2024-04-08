package SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateFuncionRequest {
    @NotNull
    Long peliculaID;
    @NotNull
    LocalDate fechaFuncion;
    @NotNull
    LocalTime horaFuncion;
    @NotNull
    Integer precioFuncion;
    @NotNull
    Integer nroSala;
}
