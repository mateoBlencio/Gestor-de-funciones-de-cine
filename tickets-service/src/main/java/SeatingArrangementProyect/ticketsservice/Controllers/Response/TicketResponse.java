package SeatingArrangementProyect.ticketsservice.Controllers.Response;

import SeatingArrangementProyect.ticketsservice.ClientFeign.Dtos.FuncionDto;
import SeatingArrangementProyect.ticketsservice.Model.Ticket;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketResponse {
    Long id;
    LocalDate fechaEmision;
    Integer fila;
    Integer columna;
    Integer clienteId;
    FuncionDtoResponse funcionDto;

    public static TicketResponse from(Ticket aTicket, FuncionDto dto){
        return TicketResponse.builder()
                .id(aTicket.getId())
                .funcionDto(FuncionDtoResponse.from(dto))
                .fechaEmision(aTicket.getFechaEmision())
                .fila(aTicket.getFila())
                .columna(aTicket.getColumna())
                .clienteId(aTicket.getClienteId())
                .build();
    }
}
