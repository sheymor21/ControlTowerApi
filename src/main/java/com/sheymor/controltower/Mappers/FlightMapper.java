package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Flight.FlightAddDTO;
import com.sheymor.controltower.Dto.Flight.FlightsGetDTO;
import com.sheymor.controltower.Entities.Flight;

public abstract class FlightMapper {
    public static Flight toFlights(FlightAddDTO dto) {
        Flight flight = new Flight();
        flight.setAirplaneCode(dto.airplaneCode());
        flight.setAirportHomeCode(dto.airportHomeCode());
        flight.setDepartureTime(dto.departureTime());
        flight.setArrivalTime(dto.arrivalTime());
        flight.setAirportDestinationCode(dto.airportDestinationCode());
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
