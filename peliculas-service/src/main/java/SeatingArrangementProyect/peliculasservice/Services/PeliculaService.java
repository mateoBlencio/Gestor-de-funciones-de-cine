package SeatingArrangementProyect.peliculasservice.Services;

import SeatingArrangementProyect.peliculasservice.Controllers.Responses.PeliculaResponse;
import SeatingArrangementProyect.peliculasservice.Model.*;
import SeatingArrangementProyect.peliculasservice.Repositories.CalificacionPeliculaRepository;
import SeatingArrangementProyect.peliculasservice.Repositories.EstadoPeliculaRepository;
import SeatingArrangementProyect.peliculasservice.Repositories.PeliculaRespository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeliculaService {
    final PeliculaRespository peliculaRespository;
    final CalificacionPeliculaRepository calificacionRepository;
    final PeliculaXCategoriaService peliculaXCategoriaService;
    final EstadoPeliculaRepository estadoPeliculaRepository;

    private PeliculaResponse toPeliculaResponse(Pelicula pelicula){
        Set<String> categorias = peliculaXCategoriaService
                .getCategoriasXPelicula(pelicula.getId())
                .stream().map(CategoriaPelicula::getNombre)
                .collect(Collectors.toSet());

        return PeliculaResponse.from(pelicula, categorias);
    }

    public List<PeliculaResponse> getAll(){
        return peliculaRespository.findAll().stream().map(this::toPeliculaResponse).toList();

    }

    public PeliculaResponse getOne(Long id){
        Pelicula pelicula = peliculaRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Pelicula not found"));
        return toPeliculaResponse(pelicula);
    }

    public List<PeliculaResponse> getPeliculasEnCarteleras(){
        return peliculaRespository.findPeliculasByEstadoPeliculaBD_Nombre("En cartelera")
                .stream().map(this::toPeliculaResponse).toList();
    }

    @Transactional
    public PeliculaResponse create(String nombreP, Integer ano_produccionP, Float duracionP,
                           String sinopsisP, Integer nroCalificacionPelicula, Integer anoActual,
                           Set<String> categorias){
        // el año actual se manda desde el front

        val calificacionPelicula = calificacionRepository.findById(nroCalificacionPelicula)
                .orElseThrow(()-> new IllegalArgumentException("Calificacion not found"));

        val estadoInicial = estadoPeliculaRepository.findById(1)
                .orElseThrow(()-> new IllegalArgumentException("Estado not found"));

        Pelicula pelicula = new Pelicula(nombreP, ano_produccionP, duracionP, sinopsisP, calificacionPelicula, estadoInicial);

        if (pelicula.tieneDuracionMayorCero() && pelicula.esAnoActualOMenor(anoActual)) {
            Pelicula peliculaCreada = peliculaRespository.save(pelicula);
            peliculaXCategoriaService.saveCategoriasPelicula(peliculaCreada.getId(), categorias);
            return this.toPeliculaResponse(peliculaCreada);
        }

        throw new IllegalArgumentException("No se pudo crear pelicula");
    }

    @Transactional
    public void deleteOne(Long id){
        Pelicula pelicula = peliculaRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Pelicula not found"));

        // Una pelicula solo puede ser eliminada si no esta disponible o si esta cargada, pero no
        // si ya fue anunciada "Proximamente" o esta en cartelera.
        if (pelicula.esNoDisponible() || pelicula.esCargada()){
            peliculaXCategoriaService.eliminarCategoriasPelicula(id);
            peliculaRespository.delete(pelicula);
        } else {
            throw new IllegalArgumentException("No se elimino pelicula");
        }

    }

    @Transactional
    public void updateEstado(Long id){

        Pelicula pelicula = peliculaRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Pelicula not found"));

        Integer idNuevoEstado = pelicula.getEstadoPeliculaBD().getId() + 1;

        val estadoNuevo = estadoPeliculaRepository.findById(idNuevoEstado)
                .orElseThrow(()-> new IllegalArgumentException("Estado not found"));

        if (pelicula.sePuedeCambiarEstado()){
            pelicula.cambiarEstadoBD(estadoNuevo);
            peliculaRespository.save(pelicula);
        } else {
            throw new IllegalArgumentException("No se pudo cambiar estado");
        }
    }
}
