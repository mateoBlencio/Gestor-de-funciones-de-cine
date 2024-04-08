package SeatingArrangementProyect.funcionesservice.funcionesservice.Services;

import SeatingArrangementProyect.funcionesservice.funcionesservice.ClientFeign.Dtos.PeliculaDTO;
import SeatingArrangementProyect.funcionesservice.funcionesservice.ClientFeign.PeliculaFeignService;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Sala;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Responses.FuncionResponse;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Model.Funcion;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories.FuncionRepository;
import SeatingArrangementProyect.funcionesservice.funcionesservice.Repositories.SalaRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuncionService {
    final FuncionRepository funcionRepository;
    final SalaRepository salaRepository;
    final PeliculaFeignService peliculaFeignService;

    private FuncionResponse toResponse(Funcion funcion){
        PeliculaDTO peliculaDTO = peliculaFeignService.getPeliculaForFuncion(funcion);
        return FuncionResponse.from(funcion, peliculaDTO);
    }

    public List<FuncionResponse> getAll(){
        return funcionRepository.findAll().stream().map(this::toResponse).toList();
    }

    public FuncionResponse getOne(Long funcionId){
        Funcion funcion = funcionRepository.findById(funcionId)
                .orElseThrow(()-> new IllegalArgumentException("Funcion not found"));

        return toResponse(funcion);
    }

    // Devuelve las funciones de aquellas peliculas que estan en cartelera
    public List<FuncionResponse> getFuncionesActuales(){
        val peliculas = peliculaFeignService.getCartelera();
        List<Long> idPeliculas = peliculas.stream().map(PeliculaDTO::getId).toList();

        List<Funcion> funciones = funcionRepository.findAll();

        List<Funcion> funcionesActuales = new ArrayList<>();
        for (Funcion funcion : funciones){
            if (idPeliculas.contains(funcion.getPeliculaId())){
                funcionesActuales.add(funcion);
            }
        }

        return funcionesActuales.stream().map(this::toResponse).toList();
    }

    private boolean sePuedeAsignarSala(Sala sala, LocalDate fechaFuncion, LocalTime horaFuncion, Float duracion){
        List<Funcion> funcionesEnSala = funcionRepository.findFuncionsBySalaAndFechaFuncion(sala, fechaFuncion);

        for (Funcion funcionEnSala : funcionesEnSala){
            long duracionLong = duracion.longValue();

            if (funcionEnSala.getHoraFuncion().equals(horaFuncion)){
                return false;
            }

            PeliculaDTO peliculaAsignada = peliculaFeignService.getPelicula(funcionEnSala.getPeliculaId());
            long duracionDePeliculaAsignada = peliculaAsignada.getDuracion().longValue();
            if ( funcionEnSala.getHoraFuncion().isBefore(horaFuncion)
                    && funcionEnSala.getHoraFuncion().plusMinutes(duracionDePeliculaAsignada).isAfter(horaFuncion)){
                System.out.println("No se pudo asignar sala Error:1");
                return false;
            }

            LocalTime horaTerminaFuncionACargar =  horaFuncion.plusMinutes(duracionLong);
            if ( funcionEnSala.getHoraFuncion().isBefore(horaTerminaFuncionACargar) &&
                funcionEnSala.getHoraFuncion().plusMinutes(duracionDePeliculaAsignada).isAfter(horaTerminaFuncionACargar)){
                System.out.println("No se pudo asignar sala Error:2");
                return false;
            }
        }
        return true;
    }

    @Transactional
    public FuncionResponse create(Long peliculaIdP, LocalDate fechaFuncionP, LocalTime horaFuncionP,
                          Integer precioFuncionP, Integer nroSala){

        val sala = salaRepository.findById(nroSala)
                .orElseThrow(()-> new IllegalArgumentException("Sala not found"));

        Funcion funcion = new Funcion(peliculaIdP, fechaFuncionP, horaFuncionP, precioFuncionP, sala);

        if (peliculaFeignService.existPelicula(funcion) && peliculaFeignService.estaEnCartelera(peliculaIdP)){
            val pelicula = peliculaFeignService.getPelicula(peliculaIdP);
            if (sePuedeAsignarSala(sala, fechaFuncionP, horaFuncionP, pelicula.getDuracion())) {
                Funcion funcionGuardada = funcionRepository.save(funcion);
                return toResponse(funcionGuardada);
            }
        }

        throw new IllegalArgumentException("Pelicula not save");
    }

    @Transactional
    public void deleteOne(Long funcionId){
        Funcion funcion = funcionRepository.findById(funcionId)
                .orElseThrow(()-> new IllegalArgumentException("Funcion not found"));

        funcionRepository.delete(funcion);
    }

    @Transactional
    public void update(Long funcionId, Long peliculaIdP, LocalDate fechaFuncionP, LocalTime horaFuncionP,
                       Integer precioFuncionP, Integer nroSala){

        Funcion funcion = funcionRepository.findById(funcionId)
                .orElseThrow(()-> new IllegalArgumentException("Funcion not found"));

        PeliculaDTO peliculaDTO = peliculaFeignService.getPelicula(peliculaIdP);

        val sala = salaRepository.findById(nroSala)
                .orElseThrow(()-> new IllegalArgumentException("Sala not found"));

        if (sePuedeAsignarSala(sala, fechaFuncionP, horaFuncionP, peliculaDTO.getDuracion())){
            funcion.update(peliculaIdP, fechaFuncionP, horaFuncionP, precioFuncionP, sala);
            funcionRepository.save(funcion);
        } else {
            throw new IllegalArgumentException("Funcion not update");
        }
    }
}
