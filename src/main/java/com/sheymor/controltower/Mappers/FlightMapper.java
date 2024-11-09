package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Flight.FlightAddDTO;
import com.sheymor.controltower.Dto.Flight.FlightsGetDTO;
import com.sheymor.controltower.Entities.Flight;
import org.apache.commons.validator.routines.DateValidator;

import java.util.Date;
import java.util.TimeZone;


public abstract class FlightMapper {
    public static Flight toFlights(FlightAddDTO dto) {
        DateValidator dateValidator = DateValidator.getInstance();
        String pattern = "yyyy/MM/dd-HH:mm";
        TimeZone timezone = TimeZone.getTimeZone("UTC");
        Date departureTime = dateValidator.validate(dto.departureTime(),pattern,timezone);
        Date arrivalTime = dateValidator.validate(dto.arrivalTime(),pattern,timezone);
        Flight flight = new Flight();
        flight.setAirplaneCode(dto.airplaneCode());
        flight.setAirportHomeCode(dto.airportHomeCode());
        flight.setAirportDestinationCode(dto.airportDestinationCode());
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        return flight;
    }


    public static FlightsGetDTO toGetFlightDTO(Flight flight) {
        return new FlightsGetDTO(
                flight.getFlightId(),
                flight.getAirplaneCode(),
                flight.getAirportHomeCode(),
                flight.getAirportDestinationCode(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getStatus().name().toLowerCase()
        );
    }
}
