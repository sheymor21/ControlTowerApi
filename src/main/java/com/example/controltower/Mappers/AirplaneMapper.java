package com.example.controltower.Mappers;

import com.example.controltower.Dto.Airplane.CreateAirplaneDTO;
import com.example.controltower.Dto.Airplane.GetAirplaneDTO;
import com.example.controltower.Entities.Airplane;
import com.example.controltower.Entities.Airport;

import java.util.ArrayList;
import java.util.List;

public abstract class AirplaneMapper {
    public static Airplane toAirplane(CreateAirplaneDTO dto) {
        Airplane airplane = new Airplane();
        airplane.setCode(dto.getCode());
        return airplane;
    }

    public static GetAirplaneDTO toGetAirplaneDTO(Airplane airplane) {
        GetAirplaneDTO dto = new GetAirplaneDTO();
        dto.setCode(airplane.getCode());
        Airport airport = airplane.getAirport();
        dto.setAirportCode(airport.getCode());
        dto.setAirportName(airport.getAirportName());
        dto.setAirportCity(airport.getAirportCity());
        dto.setAirportCountry(airport.getAirportCountry());
        return dto;
    }

    public static List<GetAirplaneDTO> toGetAirplaneDTO(Iterable<Airplane> airplanes) {
        List<GetAirplaneDTO> dtoList = new ArrayList<>();
        for (Airplane airplane : airplanes) {
            dtoList.add(toGetAirplaneDTO(airplane));
        }
        return dtoList;
    }
}
