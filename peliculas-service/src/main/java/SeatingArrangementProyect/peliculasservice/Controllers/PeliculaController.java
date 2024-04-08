package SeatingArrangementProyect.peliculasservice.Controllers;

import SeatingArrangementProyect.peliculasservice.Controllers.Requests.CreatePeliculaRequest;
import SeatingArrangementProyect.peliculasservice.Controllers.Responses.PeliculaResponse;
import SeatingArrangementProyect.peliculasservice.Services.PeliculaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas/peliculas")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PeliculaController {
    final PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            val peliculas = peliculaService.getAll();
            return ResponseEntity.ok(peliculas);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{peliculaID}")
    public ResponseEntity<Object> getOne(@PathVariable Long peliculaID){
        try{
            val pelicula = peliculaService.getOne(peliculaID);
            return ResponseEntity.ok(pelicula);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cartelera")
    public ResponseEntity<Object> getCartelera(){
        try{
            val peliculas = peliculaService.getPeliculasEnCarteleras();
            return ResponseEntity.ok(peliculas);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreatePeliculaRequest dto){
        try{
            val pelicula = peliculaService.create(dto.getNombre(), dto.getAno_produccion(),
                    dto.getDuracion(), dto.getSinopsis(), dto.getNroCalificacionPelicula(), dto.getAnoActual(),
                    dto.getCategorias());
            return ResponseEntity.ok(pelicula);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{peliculaId}")
    public ResponseEntity<Object> delete(@PathVariable Long peliculaId){
        try{
            peliculaService.deleteOne(peliculaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{peliculaId}")
    public ResponseEntity<Object> update(@PathVariable Long peliculaId){
        try{
            peliculaService.updateEstado(peliculaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
