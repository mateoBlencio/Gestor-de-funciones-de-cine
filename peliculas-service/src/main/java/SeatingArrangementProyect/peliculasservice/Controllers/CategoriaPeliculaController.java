package SeatingArrangementProyect.peliculasservice.Controllers;

import SeatingArrangementProyect.peliculasservice.Controllers.Requests.CreateCategoriaRequest;
import SeatingArrangementProyect.peliculasservice.Controllers.Requests.UpdateCategoriaRequest;
import SeatingArrangementProyect.peliculasservice.Services.CategoriaPeliculaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/peliculas/categorias")
@AllArgsConstructor
public class CategoriaPeliculaController {
    final CategoriaPeliculaService categoriaService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            val categorias = categoriaService.getAll();
            return ResponseEntity.ok(categorias);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateCategoriaRequest dto){
        try{
            val categoria = categoriaService.create(dto.getNombre());
            return ResponseEntity.ok(categoria);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Object> delete(@PathVariable Integer categoriaId){
        try{
            categoriaService.deleteOne(categoriaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<Object> update(@PathVariable Integer categoriaId,@RequestBody UpdateCategoriaRequest dto){
        try{
            categoriaService.update(categoriaId, dto.getNombre());
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
