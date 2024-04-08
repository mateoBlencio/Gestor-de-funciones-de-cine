package SeatingArrangementProyect.ticketsservice.Controllers;

import SeatingArrangementProyect.ticketsservice.Controllers.Requests.CreateTicketRequest;
import SeatingArrangementProyect.ticketsservice.Controllers.Response.TicketResponse;
import SeatingArrangementProyect.ticketsservice.Services.TicketService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets/tickets")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TicketController {
    final TicketService ticketService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            val tickets = ticketService.getAll();
            return ResponseEntity.ok(tickets);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{funcionId}")
    public ResponseEntity<Object> getAllPorFuncion(@PathVariable Long funcionId){
        try {
            val tickets = ticketService.getAllPorFuncion(funcionId);
            return ResponseEntity.ok(tickets);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateTicketRequest dto){
        try{
            val ticket = ticketService.create(dto.getFuncionId(), dto.getFechaEmision(),
                    dto.getFila(), dto.getColumna(), dto.getClienteId());
            return ResponseEntity.ok(ticket);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
