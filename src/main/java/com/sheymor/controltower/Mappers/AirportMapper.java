package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Airports.AirportAddDTO;
import com.sheymor.controltower.Entities.Airport;

public abstract class AirportMapper {
    public static Airport ToAirport(AirportAddDTO dto) {
        Airport airport = new Airport();
        airport.setAirportName(dto.name());
        airport.setCode(dto.code());
        airport.setAirportCity(dto.city());
        airport.setAirportCountry(dto.country());
        return airport;
    }
}
