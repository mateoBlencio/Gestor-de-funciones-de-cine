package SeatingArrangementProyect.ticketsservice.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Generated;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "ticket")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "funcion_id", nullable = false)
    Long funcionId;

    @Column(name = "fecha_emision", nullable = false)
    LocalDate fechaEmision;

    @Column(name = "fila", nullable = false)
    Integer fila;

    @Column(name = "columna", nullable = false)
    Integer columna;

    @Column(name = "cliente_id", nullable = false)
    Integer clienteId;

    public Ticket(){super();}

    public Ticket(Long funcionIdP, LocalDate fechaEmisionP, Integer filaP, Integer columnaP,
                  Integer clienteIdP){
        super();
        funcionId = funcionIdP;
        fechaEmision = fechaEmisionP;
        fila = filaP;
        columna = columnaP;
        clienteId = clienteIdP;
    }
}
