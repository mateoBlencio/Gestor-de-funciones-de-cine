package SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeliculaDTO {
    Long id;
    String nombre;
    Float duracion;
    String nombreCalificacionPelicula;
}
//           "id": 1,
//            "nombre": "Matrix",
//            "ano_produccion": 1999,
//            "duracion": 136.5,
//            "nombreEstadoPelicula": null,
//            "sinopsis": "En un futuro distópico, Neo descubre la verdad sobre su realidad.",
//            "nombreCalificacionPelicula": null,
//            "categorias": null