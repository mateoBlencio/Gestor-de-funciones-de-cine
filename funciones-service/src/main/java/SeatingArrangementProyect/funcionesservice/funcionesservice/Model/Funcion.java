package SeatingArrangementProyect.funcionesservice.funcionesservice.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "funcion")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "pelicula_id")
    Long peliculaId;

    @Column(name = "fecha_funcion")
    LocalDate fechaFuncion;

    @Column(name = "hora_funcion")
    LocalTime horaFuncion;

    @Column(name = "precio_funcion")
    Integer precioFuncion;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    Sala sala;

    public Funcion(){super();}

    public Funcion(Long peliculaIdP, LocalDate fechaFuncionP, LocalTime horaFuncionP,
                   Integer precioFuncionP, Sala salaP){
        super();
        peliculaId = peliculaIdP;
        fechaFuncion = fechaFuncionP;
        horaFuncion = horaFuncionP;
        precioFuncion = precioFuncionP;
        sala = salaP;
    }

    public void update(Long peliculaIdP, LocalDate fechaFuncionP, LocalTime horaFuncionP,
                   Integer precioFuncionP, Sala salaP){
        peliculaId = peliculaIdP;
        fechaFuncion = fechaFuncionP;
        horaFuncion = horaFuncionP;
        precioFuncion = precioFuncionP;
        sala = salaP;
    }
}
