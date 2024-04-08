package SeatingArrangementProyect.funcionesservice.funcionesservice.ClientFeign.Dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeliculaDTO {
    Long id;
    String nombre;
    Integer ano_produccion;
    Float duracion;
    String nombreEstadoPelicula;
    String sinopsis;
    String nombreCalificacionPelicula;
    Set<String> categorias;
}