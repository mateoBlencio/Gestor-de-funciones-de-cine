package SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers;

import SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests.CreateFuncionRequest;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Controllers.Requests.UpdateFuncionRequest;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Services.FuncionService;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/funciones/funciones")
@AllArgsConstructor
public class FuncionController {
    final FuncionService funcionService;

    @GetMapping
    @CircuitBreaker(name = "peliculasCB", fallbackMethod = "fallbackToFuncionServiceList")
    public ResponseEntity<Object> getAll(){
        try {
            val funciones = funcionService.getAll();
            return ResponseEntity.ok(funciones);
        } catch (FeignException e) { // Captura excepciones de Feign
            fallbackToFuncionServiceList(e);
            throw e;
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{funcionId}")
    @CircuitBreaker(name = "peliculasCB", fallbackMethod = "fallbackToFuncionService")
    public ResponseEntity<Object> getOne(@PathVariable Long funcionId){
        try {
            val funcion = funcionService.getOne(funcionId);
            return ResponseEntity.ok(funcion);
        } catch (FeignException e) { // Captura excepciones de Feign
            fallbackToFuncionServiceList(e);
            throw e;
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cartelera")
    @CircuitBreaker(name = "peliculasCB", fallbackMethod = "fallbackToFuncionServiceList")
    public ResponseEntity<Object> getFuncionesActuales(){
        try{
            val funciones = funcionService.getFuncionesActuales();
            return ResponseEntity.ok(funciones);
        } catch (FeignException e) { // Captura excepciones de Feign
            fallbackToFuncionServiceList(e);
            throw e;
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @CircuitBreaker(name = "peliculasCB", fallbackMethod = "fallbackToFuncionService")
    public ResponseEntity<Object> create(@RequestBody CreateFuncionRequest dto){
        try {
            val funcion = funcionService.create(dto.getPeliculaID(), dto.getFechaFuncion(), dto.getHoraFuncion(),
                    dto.getPrecioFuncion(), dto.getNroSala());
            return ResponseEntity.ok(funcion);
        } catch (FeignException e) { // Captura excepciones de Feign
            fallbackToFuncionService(dto, e);
            throw e;
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{funcionId}")
    public ResponseEntity<Object> delete(@PathVariable Long funcionId){
        try{
            funcionService.deleteOne(funcionId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{funcionId}")
    public ResponseEntity<Object> update(@PathVariable Long funcionId, @RequestBody UpdateFuncionRequest dto){
        try{
            funcionService.update(funcionId, dto.getPeliculaID(), dto.getFechaFuncion(), dto.getHoraFuncion(),
                    dto.getPrecioFuncion(), dto.getNroSala());
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<Object> fallbackToFuncionServiceList(RuntimeException e){
        return new ResponseEntity("No se pudo obtener peliculas.", HttpStatus.OK);
    }

    private ResponseEntity<Object> fallbackToFuncionService(@RequestBody CreateFuncionRequest dto, RuntimeException e){
        return new ResponseEntity("No se pudo obtener pelicula con id: " + dto.getPeliculaID(), HttpStatus.OK);
    }
}
