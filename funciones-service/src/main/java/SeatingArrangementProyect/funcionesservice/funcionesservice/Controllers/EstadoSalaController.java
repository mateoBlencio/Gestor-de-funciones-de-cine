package SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests.CreateEstadoSalaRequest;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests.UpdateEstadoSalaRequest;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Services.EstadoSalaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequestMapping("/funciones/estadossalas")
public class EstadoSalaController {
    final EstadoSalaService estadoSalaService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            val estados = estadoSalaService.getAll();
            return ResponseEntity.ok(estados);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateEstadoSalaRequest dto){
        try{
            val estado = estadoSalaService.create(dto.getNombre(), dto.getDescripcion());
            return ResponseEntity.ok(estado);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<Object> update(@PathVariable Integer estadoId,@RequestBody UpdateEstadoSalaRequest dto){
        try{
            estadoSalaService.update(estadoId, dto.getNombre(), dto.getDescripcion());
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Object> delete(@PathVariable Integer estadoId){
        try{
            estadoSalaService.deleteOne(estadoId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
