package com.sheymor.controltower.Dto.Flight;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Flight}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
