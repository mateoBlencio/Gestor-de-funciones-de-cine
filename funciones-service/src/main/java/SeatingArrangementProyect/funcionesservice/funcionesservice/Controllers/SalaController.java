package SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests.CreateSalaRequest;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests.UpdateSalaRequest;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Responses.SalaResponse;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Services.SalaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/funciones/salas")
@AllArgsConstructor
public class SalaController {
    final SalaService salaService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            val salas = salaService.getAll().stream().map(SalaResponse::from);
            return ResponseEntity.ok(salas);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateSalaRequest dto){
        try{
            val sala = salaService.create(dto.getTipoSala(), dto.getFilas(), dto.getColumnas());
            return ResponseEntity.ok(SalaResponse.from(sala));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{salaId}")
    public ResponseEntity<Object> delete(@PathVariable Integer salaId){
        try{
            salaService.deleteOne(salaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{salaId}")
    public ResponseEntity<Object> update(@PathVariable Integer salaId, @RequestBody UpdateSalaRequest dto){
        try{
            salaService.update(salaId, dto.getNroEstado(), dto.getTipoSala(), dto.getFilas(), dto.getColumnas());
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
