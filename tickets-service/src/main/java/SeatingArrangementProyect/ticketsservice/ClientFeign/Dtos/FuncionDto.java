package SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuncionDto {
    Long id;
    PeliculaDTO pelicula;
    LocalDate fechaFuncion;
    LocalTime horaFuncion;
    Integer precioFuncion;
    SalaDTO sala;
}