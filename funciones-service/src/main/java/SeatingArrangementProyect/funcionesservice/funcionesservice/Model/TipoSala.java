package SeatingArrangementProyect.funcionesservice.funcionesservice.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Table(name = "tipo_sala")
public class TipoSala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "nombre")
    String nombre;

    public TipoSala(){super();}

    public TipoSala(String nombreP){
        super();
        nombre = nombreP;
    }

    public void update(String nombreP){
        nombre = nombreP;
    }
}
