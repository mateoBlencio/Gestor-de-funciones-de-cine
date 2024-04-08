package SeatingArrangementProyect.funcionesservice.funcionesservice.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_sala")
    Integer nroSala;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    EstadoSala estadoSala;

    @ManyToOne
    @JoinColumn(name = "tipo_sala_id")
    TipoSala tipoSala;

    @Column(name = "filas")
    Integer filas; // este atributo sirve para indicar la cantidad de filas

    @Column(name = "columnas")
    Integer columnas;

    public Sala(){super();}

    public Sala(EstadoSala estadoSalaP, TipoSala tipoSalaP, Integer filasP, Integer columnasP){
        super();
        estadoSala = estadoSalaP;
        tipoSala = tipoSalaP;
        filas = filasP;
        columnas = columnasP;
    }

    public void update(EstadoSala estadoSalaP, TipoSala tipoSalaP, Integer filasP, Integer columnasP){
        estadoSala = estadoSalaP;
        tipoSala = tipoSalaP;
        filas = filasP;
        columnas = columnasP;
    }
}
