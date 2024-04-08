package SeatingArrangementProyect.ticketsservice.Controllers.Response;

import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.FuncionDto;
import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.PeliculaDTO;
import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.SalaDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuncionDtoResponse {
    Long id;
    LocalDate fechaFuncion;
    LocalTime horaFuncion;
    Integer precioFuncion;

    // PeliculaDTO pelicula;
    PeliculaDTOResponse pelicula;

    // SalaResponse sala;
    SalaDTOResponse sala;

    public static FuncionDtoResponse from(FuncionDto dto){
        return FuncionDtoResponse.builder()
                .id(dto.getId())
                .fechaFuncion(dto.getFechaFuncion())
                .horaFuncion(dto.getHoraFuncion())
                .precioFuncion(dto.getPrecioFuncion())
                .pelicula(PeliculaDTOResponse.from(dto.getPelicula()))
                .sala(SalaDTOResponse.from(dto.getSala()))
                .build();
    }
}
