package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Airports.CreateAirportDTO;
import com.sheymor.controltower.Entities.Airport;

public abstract class AirportMapper {
    public static Airport ToAirport(CreateAirportDTO dto) {
        Airport airport = new Airport();
        airport.setAirportName(dto.getName());
        airport.setCode(dto.getCode());
        airport.setAirportCity(dto.getCity());
        airport.setAirportCountry(dto.getCountry());
        return airport;
    }
}
