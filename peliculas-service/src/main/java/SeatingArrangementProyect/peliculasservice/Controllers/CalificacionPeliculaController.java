package SeatingArrangementProyect.peliculasservice.Controllers;

import SeatingArrangementProyect.peliculasservice.Controllers.Requests.CreateCalificacionRequest;
import SeatingArrangementProyect.peliculasservice.Controllers.Requests.UpdateCalificacionRequest;
import SeatingArrangementProyect.peliculasservice.Services.CalificacionPeliculaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/peliculas/calificaciones")
public class CalificacionPeliculaController {
    final CalificacionPeliculaService calificacionService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            val calificaciones = calificacionService.getAll();
            return ResponseEntity.ok(calificaciones);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateCalificacionRequest dto){
        try{
            val calificacion = calificacionService.create(dto.getNombre(), dto.getDescripcion());
            return ResponseEntity.ok(calificacion);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{calificacionId}")
    public ResponseEntity<Object> delete(@PathVariable Integer calificacionId){
        try{
            calificacionService.deleteOne(calificacionId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{calificacionId}")
    public ResponseEntity<Object> update(@PathVariable Integer calificacionId, @RequestBody UpdateCalificacionRequest dto){
        try{
            calificacionService.update(calificacionId, dto.getNombre(), dto.getDescripcion());
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
