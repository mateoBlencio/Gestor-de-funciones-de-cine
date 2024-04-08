package SeatingArrangementProyect.funcionesservice.funcionesservice.Responses;

import SeatingArrangementProyect.funcionesservice.funcionesservice.ClientFeign.Dtos.PeliculaDTO;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Funcion;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuncionResponse {
    Long id;
    PeliculaDTO pelicula;
    LocalDate fechaFuncion;
    LocalTime horaFuncion;
    Integer precioFuncion;
    SalaResponse sala;

    public static FuncionResponse from(Funcion aFuncion, PeliculaDTO dto){
        return FuncionResponse.builder()
                .id(aFuncion.getId())
                .pelicula(dto)
                .fechaFuncion(aFuncion.getFechaFuncion())
                .horaFuncion(aFuncion.getHoraFuncion())
                .precioFuncion(aFuncion.getPrecioFuncion())
                .sala(SalaResponse.from(aFuncion.getSala()))
                .build();
    }
}
