package SeatingArrangementProyect.funcionesservice.funcionesservice.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "estado_sala")
@Data
public class EstadoSala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "nombre", unique = true)
    String nombre;

    @Column(name = "descripcion")
    String descripcion;

    public EstadoSala(){super();}

    public EstadoSala(String nombreP, String descripcionP){
        super();
        nombre = nombreP;
        descripcion = descripcionP;
    }

    public void update(String nombreP, String descripcionP){
        nombre = nombreP;
        descripcion = descripcionP;
    }
}
