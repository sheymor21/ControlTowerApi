package com.sheymor.controltower.Dto.Flight;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidDate;

import java.util.Date;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Flight}
 */
public record FlightAddDTO(
        @ValidAirplaneCodePresent String airplaneCode,
        @ValidAirportCodePresent(message = "Invalid airportHome Code") String airportHomeCode,
        @ValidAirportCodePresent(message = "Invalid airportDestination Code") String airportDestinationCode,
        @ValidDate Date departureTime,
        @ValidDate Date arrivalTime
) {

}
