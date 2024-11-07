package com.sheymor.controltower.Dto.Ticket;

import com.sheymor.controltower.Validations.Customs.ValidCabinClass;

public record FlightTicketAddDTO(
        String flightId,
        String passengerId,
        @ValidCabinClass() String cabinClass
) {

}
