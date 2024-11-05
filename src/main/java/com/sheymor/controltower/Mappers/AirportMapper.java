package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Airports.AirportAddDTO;
import com.sheymor.controltower.Dto.Airports.AirportGetDTO;
import com.sheymor.controltower.Entities.Airport;

import java.util.ArrayList;
import java.util.List;

public abstract class AirportMapper {
    public static Airport ToAirport(AirportAddDTO dto) {
        Airport airport = new Airport();
        airport.setAirportName(dto.name());
        airport.setCode(dto.code());
        airport.setAirportCity(dto.city());
        airport.setAirportCountry(dto.country());
        return airport;
    }

    public static Iterable<AirportGetDTO> toDTO(Iterable<Airport> airports) {
        List<AirportGetDTO> airportsDto = new ArrayList<>();
        for (Airport airport : airports) {
            AirportGetDTO airportGetDTO = toDTO(airport);
            airportsDto.add(airportGetDTO);
        }
        return airportsDto;
    }

    public static AirportGetDTO toDTO(Airport airport) {
        return new AirportGetDTO(
                airport.getAirportName(),
                airport.getAirportCity(),
                airport.getAirportCountry(),
                airport.getCode()
        );
    }
}
