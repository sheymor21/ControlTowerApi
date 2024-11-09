package com.sheymor.controltower.Dto.Flight;


import java.util.Date;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Flight}
 */
public record FlightsGetDTO(
        String flightId,
        String airplaneCode,
        String airportHomeCode,
        String airportDestinationCode,
        Date departureTime,
        Date arrivalTime,
        String status
) {
}
