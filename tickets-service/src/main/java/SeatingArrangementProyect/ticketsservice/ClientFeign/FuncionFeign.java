package SeatingArrangementProyect.ticketsservice.ClientFeign;

import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.FuncionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "funciones-service", path = "/funciones/funciones")
public interface FuncionFeign {
    @GetMapping
    ResponseEntity<List<FuncionDto>> getAllFunciones();

    @GetMapping("/{funcionId}")
    ResponseEntity<FuncionDto> getOne(@PathVariable Long funcionId);

    @GetMapping("cartelera")
    ResponseEntity<List<FuncionDto>> getFuncionesActuales();
}
