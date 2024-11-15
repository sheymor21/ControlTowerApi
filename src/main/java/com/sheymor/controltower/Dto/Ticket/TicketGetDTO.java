package com.sheymor.controltower.Dto.Ticket;


/**
 * DTO for {@link com.sheymor.controltower.Entities.FlightTicket}
 */
public record TicketGetDTO(
        String ticketId,
        Boolean boardedStatus,
        String cabinClass
) {

}
