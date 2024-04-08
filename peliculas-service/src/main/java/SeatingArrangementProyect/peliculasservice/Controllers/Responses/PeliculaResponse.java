package SeatingArrangementProyect.peliculasservice.Controllers.Responses;

import SeatingArrangementProyect.peliculasservice.Model.EstadoPeliculaBD;
import SeatingArrangementProyect.peliculasservice.Model.Pelicula;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeliculaResponse {
    Long id;
    String nombre;
    Integer ano_produccion;
    Float duracion;
    String nombreEstadoPelicula;
    String sinopsis;
    String nombreCalificacionPelicula;
    Set<String> categorias;

    public static PeliculaResponse from(Pelicula aPelicula, Set<String> categorias){
        return PeliculaResponse.builder()
                .id(aPelicula.getId())
                .nombre(aPelicula.getNombre())
                .ano_produccion(aPelicula.getAno_produccion())
                .duracion(aPelicula.getDuracion())
                .nombreEstadoPelicula(aPelicula.getEstadoPeliculaBD().getNombre())
                .sinopsis(aPelicula.getSinopsis())
                .nombreCalificacionPelicula(aPelicula.getCalificacionPelicula().getNombre())
                .categorias(categorias)
                .build();
    }
}
