package SeatingArrangementProyect.funcionesservice.funcionesservice.ClientFeign;

import SeatingArrangementProyect.funcionesservice.funcionesservice.ClientFeign.Dtos.PeliculaDTO;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Funcion;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Responses.FuncionResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Component
public class PeliculaFeignService {
    final PeliculaFeign peliculaFeign;

    public PeliculaDTO getPeliculaForFuncion(Funcion funcion){
       return peliculaFeign.getOne(funcion.getPeliculaId()).getBody();
    }

    public boolean existPelicula(Funcion funcion){
        PeliculaDTO peliculaDTO = peliculaFeign.getOne(funcion.getPeliculaId()).getBody();
        return peliculaDTO != null;
    }

    public PeliculaDTO getPelicula(Long peliculaId){
        return peliculaFeign.getOne(peliculaId).getBody();
    }

    public boolean estaEnCartelera(Long peliculaId){
        List<PeliculaDTO> peliculasEnCartelera = peliculaFeign.getCartelera().getBody();
        if (peliculasEnCartelera.isEmpty()){
            return false;
        }
        List<Long> idsPeliculas = peliculasEnCartelera.stream().map(PeliculaDTO::getId).toList();
        return idsPeliculas.contains(peliculaId);
    }

    public List<PeliculaDTO> getCartelera(){
        return peliculaFeign.getCartelera().getBody();
    }
}
