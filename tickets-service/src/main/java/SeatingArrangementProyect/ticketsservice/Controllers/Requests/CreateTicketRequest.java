package SeatingArrangementProyect.ticketsservice.Controllers.Requests;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTicketRequest {
    @NotNull
    Long funcionId;
    @NotNull
    LocalDate fechaEmision;
    @NotNull
    Integer fila;
    @NotNull
    Integer columna;
    @NotNull
    Integer clienteId;
}
