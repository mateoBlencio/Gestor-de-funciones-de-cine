package SeatingArrangementProyect.ticketsservice.Services;

import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.FuncionDto;
import SeatingArrangementProyect.ticketsservice.ClientFeign.FuncionesFeignService;
import SeatingArrangementProyect.ticketsservice.Controllers.Response.TicketResponse;
import SeatingArrangementProyect.ticketsservice.Model.Ticket;
import SeatingArrangementProyect.ticketsservice.Respositories.TicketRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketService {
    final TicketRepository ticketRepository;
    final FuncionesFeignService funcionesFeignService;

    private TicketResponse toResponse(Ticket ticket){
        FuncionDto funcion = funcionesFeignService.getFuncion(ticket.getFuncionId());
        return TicketResponse.from(ticket, funcion);
    }

    public List<TicketResponse> getAll(){
         return ticketRepository.findAll().stream().map(this::toResponse).toList();
    }

    public List<TicketResponse> getAllPorFuncion(Long funcionId){
        return ticketRepository.findTicketsByFuncionId(funcionId).stream().map(this::toResponse).toList();
    }

    private boolean existeFuncionActual(Long funcionId){
        List<Long> idsFunciones = funcionesFeignService.getFuncionesActuales().stream()
                .map(FuncionDto::getId).toList();
        return idsFunciones.contains(funcionId);
    }

    private boolean fechaEmisionEsAnteriorAFuncion(LocalDate fechaEmision, Long funcionId){
        val funcion = funcionesFeignService.getFuncion(funcionId);
        return fechaEmision.isBefore(funcion.getFechaFuncion());
    }

    private boolean existeLugar(Long funcionId, Integer fila, Integer columna){
        val funcion = funcionesFeignService.getFuncion(funcionId);
        List<Ticket> ticketsDeFuncion = ticketRepository.findTicketsByFuncionId(funcionId);

        int cantidadDeLugares = (int) funcion.getSala().getFilas() * funcion.getSala().getColumnas();
        if (ticketsDeFuncion.size() >= cantidadDeLugares){
            return false;
        }
        if ( columna < 1 || funcion.getSala().getColumnas() < columna ) {
            return false;
        }
        if (fila < 1 || funcion.getSala().getFilas() < fila){
            return false;
        }
        for (Ticket ticketDeFuncion : ticketsDeFuncion){
            if ( ticketDeFuncion.getFila().equals(fila) && ticketDeFuncion.getColumna().equals(columna) ){
                return false;
            }
        }
        return true;
    }


    public TicketResponse create(Long funcionIdP, LocalDate fechaEmisionP, Integer filaP,
                         Integer columnaP, Integer clienteIdP){

        boolean existeFuncion = existeFuncionActual(funcionIdP);
        boolean fechaEmisionEsAnteriorAFuncion = fechaEmisionEsAnteriorAFuncion(fechaEmisionP, funcionIdP);
        boolean existeLugar = existeLugar(funcionIdP, filaP, columnaP);

        if (existeFuncion && fechaEmisionEsAnteriorAFuncion && existeLugar){
            Ticket ticket = new Ticket(funcionIdP, fechaEmisionP, filaP, columnaP, clienteIdP);
            return toResponse(ticketRepository.save(ticket));
        }
        throw new IllegalArgumentException("No se pudo crear ticket");
    }
}


