package SeatingArrangementProyect.peliculasservice.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "calificacion")
public class CalificacionPelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "descripcion")
    String descripcion;

    public CalificacionPelicula(){super();}

    public CalificacionPelicula(String nombreP, String descripcionP){
        super();
        nombre = nombreP;
        descripcion = descripcionP;
    }

    public void update(String nombreP, String descripcionP){
        nombre = nombreP;
        descripcion = descripcionP;
    }
}
