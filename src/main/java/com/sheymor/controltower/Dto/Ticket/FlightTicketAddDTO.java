package com.sheymor.controltower.Dto.Ticket;

import com.sheymor.controltower.Entities.FlightTicket;

public record FlightTicketAddDTO(
        String flightId,
        String passengerId,
        FlightTicket.CabinClass cabinClass
) {

}
