package com.sheymor.controltower.Dto.Ticket;

import com.sheymor.controltower.Validations.Annotations.ValidCabinClass;

/**
 * DTO for {@link com.sheymor.controltower.Entities.FlightTicket}
 */
public record FlightTicketAddDTO(
        String flightId,
        String passengerId,
        @ValidCabinClass() String cabinClass
) {

}
