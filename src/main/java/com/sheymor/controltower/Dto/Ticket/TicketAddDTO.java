package com.sheymor.controltower.Dto.Ticket;

import com.sheymor.controltower.Validations.Annotations.ValidCabinClass;
import com.sheymor.controltower.Validations.Annotations.ValidPassengerLimit;

/**
 * DTO for {@link com.sheymor.controltower.Entities.FlightTicket}
 */
public record TicketAddDTO(
        @ValidPassengerLimit String flightId,
        String passengerId,
        @ValidCabinClass String cabinClass
) {

}
