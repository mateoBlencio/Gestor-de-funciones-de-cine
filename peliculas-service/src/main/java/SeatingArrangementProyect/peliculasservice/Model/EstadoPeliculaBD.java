package SeatingArrangementProyect.peliculasservice.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "estado_pelicula")
public class EstadoPeliculaBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "nombre")
    String nombre;

    public EstadoPeliculaBD(){super();}

    public EstadoPeliculaBD(String nombreP){
        super();
        nombre = nombreP;
    }

    public void update(String nombreP){
        nombre = nombreP;
    }
}
