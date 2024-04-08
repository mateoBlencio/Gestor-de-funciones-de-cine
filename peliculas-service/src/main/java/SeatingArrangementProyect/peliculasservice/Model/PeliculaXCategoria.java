package SeatingArrangementProyect.peliculasservice.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "pelicula_x_categoria")
public class PeliculaXCategoria {
    @EmbeddedId
    PeliculaXCategoriaId peliculaXCategoriaId;

    public PeliculaXCategoria(){super();}

    public PeliculaXCategoria(Pelicula peliculaP, CategoriaPelicula categoriaPeliculaP){
        super();
        peliculaXCategoriaId = new PeliculaXCategoriaId(peliculaP, categoriaPeliculaP);
    }
}
