package SeatingArrangementProyect.ticketsservice.Controllers.Response;

import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.PeliculaDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeliculaDTOResponse {
    Long idPelicula;
    String nombrePelicula;
    Float duracionPelicula;
    String nombreCalificacionPeliculaPelicula;

    public static PeliculaDTOResponse from(PeliculaDTO dto){
        return PeliculaDTOResponse.builder()
                .idPelicula(dto.getId())
                .nombrePelicula(dto.getNombre())
                .duracionPelicula(dto.getDuracion())
                .nombreCalificacionPeliculaPelicula(dto.getNombreCalificacionPelicula())
                .build();
    }
}
