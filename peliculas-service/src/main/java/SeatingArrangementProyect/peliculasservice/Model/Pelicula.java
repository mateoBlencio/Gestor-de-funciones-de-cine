package SeatingArrangementProyect.peliculasservice.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nombre", nullable = false)
    String nombre;

    @Column(name = "ano_produccion")
    Integer ano_produccion;

    @Column(name = "duracion")
    Float duracion;

    @ManyToOne
    @JoinColumn(name = "nro_estado")
    EstadoPeliculaBD estadoPeliculaBD;

    @Column(name = "sinopsis")
    String sinopsis;

    @ManyToOne
    @JoinColumn(name = "calificacion_id")
    CalificacionPelicula calificacionPelicula;


    public Pelicula(){super();}

    public Pelicula(String nombreP, Integer ano_produccionP, Float duracionP, String sinopsisP,
                    CalificacionPelicula calificacionPeliculaP, EstadoPeliculaBD estadoPeliculaBDP){
        super();
        nombre = nombreP;
        ano_produccion = ano_produccionP;
        duracion = duracionP;
        estadoPeliculaBD = estadoPeliculaBDP;
        sinopsis = sinopsisP;
        calificacionPelicula = calificacionPeliculaP;
    }

    public boolean tieneDuracionMayorCero(){
        return this.duracion > (float) 0;
    }

    public boolean esAnoActualOMenor(Integer anoActual){
        return this.ano_produccion <= anoActual;
    }

    public void cambiarEstadoBD(EstadoPeliculaBD estadoPeliculaBDP){
        estadoPeliculaBD = estadoPeliculaBDP;
    }

    public boolean esNoDisponible() {return estadoPeliculaBD.getId().equals(4);}

    public boolean esCargada() {
        return estadoPeliculaBD.getId().equals(1);
    }

    public boolean esEnCartelera(){ return estadoPeliculaBD.getId().equals(3);}

    public boolean esProximamente(){ return estadoPeliculaBD.getId().equals(2); }

    public boolean sePuedeCambiarEstado(){return estadoPeliculaBD.getId() < 4;}
}
