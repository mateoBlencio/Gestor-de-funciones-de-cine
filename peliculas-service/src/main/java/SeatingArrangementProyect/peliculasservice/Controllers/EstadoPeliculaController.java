package SeatingArrangementProyect.peliculasservice.Controllers;

import SeatingArrangementProyect.peliculasservice.Controllers.Requests.CreateEstadoRequest;
import SeatingArrangementProyect.peliculasservice.Controllers.Requests.UpdateEstadoRequest;
import SeatingArrangementProyect.peliculasservice.Services.EstadoPeliculaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas/estados")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class EstadoPeliculaController {
    final EstadoPeliculaService estadoService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            val estados = estadoService.getAll();
            return ResponseEntity.ok(estados);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateEstadoRequest dto){
        try{
            val estado = estadoService.create(dto.getNombre());
            return ResponseEntity.ok(estado);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Object> delete(@PathVariable Integer estadoId){
        try{
            estadoService.deleteOne(estadoId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<Object> update(@PathVariable Integer estadoId, @RequestBody UpdateEstadoRequest dto){
        try{
            estadoService.update(estadoId, dto.getNombre());
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
