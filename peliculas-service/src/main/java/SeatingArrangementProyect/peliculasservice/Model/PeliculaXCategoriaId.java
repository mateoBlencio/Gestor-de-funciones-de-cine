package SeatingArrangementProyect.peliculasservice.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Embeddable
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeliculaXCategoriaId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    CategoriaPelicula categoriaPelicula;

    public PeliculaXCategoriaId(){super();}

    public PeliculaXCategoriaId(Pelicula peliculaP, CategoriaPelicula categoriaPeliculaP){
        super();
        pelicula = peliculaP;
        categoriaPelicula = categoriaPeliculaP;
    }
}
