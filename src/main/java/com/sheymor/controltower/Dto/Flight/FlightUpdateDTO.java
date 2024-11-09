package com.sheymor.controltower.Dto.Flight;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

import java.util.Date;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Flight}
 */
public record FlightUpdateDTO(
        @ValidAirplaneCodePresent String airplaneCode,
        @ValidAirportCodePresent(message = "Invalid airportHome Code") String airportHomeCode,
        @ValidAirportCodePresent(message = "Invalid airportDestination Code") String airportDestinationCode,
        Date departureTime,
        Date arrivalTime
) {
}
