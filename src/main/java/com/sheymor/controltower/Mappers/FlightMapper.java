package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Flight.CreateFlightDTO;
import com.sheymor.controltower.Dto.Flight.GetFlightsDTO;
import com.sheymor.controltower.Entities.Flights;

public abstract class FlightMapper {
    public static Flights toFlights(CreateFlightDTO dto) {
        Flights flight = new Flights();
        flight.setAirplaneCode(dto.getAirplaneCode());
        flight.setAirportHomeCode(dto.getAirportHomeCode());
        flight.setDepartureTime(dto.getDepartureTime());
        flight.setArrivalTime(dto.getArrivalTime());
        flight.setAirportDestinationCode(dto.getAirportDestinationCode());
        return flight;
    }


    public static GetFlightsDTO toGetFlightDTO(Flights flight) {
        GetFlightsDTO dto = new GetFlightsDTO();
        dto.setFlightId(flight.getFlightId());
        dto.setAirplaneCode(flight.getAirplaneCode());
        dto.setAirportHomeCode(flight.getAirportHomeCode());
        dto.setDepartureTime(flight.getDepartureTime());
        dto.setArrivalTime(flight.getArrivalTime());
        dto.setStatus(flight.getStatus());
        dto.setAirportDestinationCode(flight.getAirportDestinationCode());
        return dto;
    }
}
