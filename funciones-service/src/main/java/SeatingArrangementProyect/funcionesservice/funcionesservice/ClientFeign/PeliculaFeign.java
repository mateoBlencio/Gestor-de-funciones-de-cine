package SeatingArrangementProyect.funcionesservice.funcionesservice.ClientFeign;

import SeatingArrangementProyect.funcionesservice.funcionesservice.ClientFeign.Dtos.PeliculaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "peliculas-service", path = "/peliculas/peliculas/")
public interface PeliculaFeign {

    @GetMapping("/{peliculaID}")
    ResponseEntity<PeliculaDTO> getOne(@PathVariable Long peliculaID);

    @GetMapping("/cartelera")
    ResponseEntity<List<PeliculaDTO>> getCartelera();
}
