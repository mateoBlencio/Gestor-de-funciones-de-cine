package SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests.CreateTipoSalaRequest;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests.UpdateTipoSalaRequest;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Services.TipoSalaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequestMapping("/funciones/tipossalas")
public class TipoSalaController {
    final TipoSalaService tipoSalaService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            val tiposSalas = tipoSalaService.getAll();
            return ResponseEntity.ok(tiposSalas);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateTipoSalaRequest dto){
        try{
            val tipoSala = tipoSalaService.create(dto.getNombre());
            return ResponseEntity.ok(tipoSala);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{tipoSalaId}")
    public ResponseEntity<Object> delete(@PathVariable Integer tipoSalaId){
        try{
            tipoSalaService.deleteOne(tipoSalaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{tipoSalaId}")
    public ResponseEntity<Object> update(@PathVariable Integer tipoSalaId, @RequestBody UpdateTipoSalaRequest dto){
        try{
            tipoSalaService.update(tipoSalaId, dto.getNombre());
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
