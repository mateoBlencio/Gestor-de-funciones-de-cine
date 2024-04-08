package SeatingArrangementProyect.peliculasservice.Controllers.Requests;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePeliculaRequest {
    @NotNull
    String nombre;
    @NotNull
    Integer ano_produccion;
    @NotNull
    Float duracion;
    @NotNull
    String sinopsis;
    @NotNull
    Integer nroCalificacionPelicula;
    @NotNull
    Set<String> categorias;
    @NotNull
    Integer anoActual;
}
