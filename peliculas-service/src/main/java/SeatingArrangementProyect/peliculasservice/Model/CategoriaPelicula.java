package SeatingArrangementProyect.peliculasservice.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "categoria")
public class CategoriaPelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "nombre", unique = true)
    String nombre;

    public CategoriaPelicula(){super();}

    public CategoriaPelicula(String nombreP){
        super();
        nombre = nombreP;
    }

    public void update(String nombreP){
        nombre = nombreP;
    }
}
