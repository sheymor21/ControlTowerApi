package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Airplane.AirplaneAddDTO;
import com.sheymor.controltower.Dto.Airplane.AirplaneGetDTO;
import com.sheymor.controltower.Entities.Airplane;
import com.sheymor.controltower.Entities.Airport;

import java.util.ArrayList;
import java.util.List;

public abstract class AirplaneMapper {
    public static Airplane toAirplane(AirplaneAddDTO dto) {
        Airplane airplane = new Airplane();
        airplane.setCode(dto.code());
        airplane.setModel(dto.model());
        airplane.setCompany(dto.company());
        airplane.setPassengerCapacity(dto.passengerCapacity());
        return airplane;
    }

    public static AirplaneGetDTO toGetAirplaneDTO(Airplane airplane) {
        Airport airport = airplane.getAirport();
        return new AirplaneGetDTO(
                airplane.getCode(),
                airport.getCode(),
                airport.getAirportName(),
                airport.getAirportCity(),
                airport.getAirportCountry()
        );
    }

    public static List<AirplaneGetDTO> toGetAirplaneDTO(Iterable<Airplane> airplanes) {
        List<AirplaneGetDTO> dtoList = new ArrayList<>();
        for (Airplane airplane : airplanes) {
            dtoList.add(toGetAirplaneDTO(airplane));
        }
        return dtoList;
    }
}
