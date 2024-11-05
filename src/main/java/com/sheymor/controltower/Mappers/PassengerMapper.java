package com.sheymor.controltower.Mappers;


import com.sheymor.controltower.Dto.Passenger.PassengerGetDTO;
import com.sheymor.controltower.Entities.Passenger;

import java.util.ArrayList;
import java.util.List;

public abstract class PassengerMapper {

    public static Iterable<PassengerGetDTO> ToGetDTO(Iterable<Passenger> passengers) {
        List<PassengerGetDTO> passengerGetDTOS = new ArrayList<>();
        for (Passenger passenger : passengers) {
            passengerGetDTOS.add(ToGetDTO(passenger));
        }
        return passengerGetDTOS;
    }

    public static PassengerGetDTO ToGetDTO(Passenger passenger) {
        return new PassengerGetDTO(
                passenger.getPassengerId(),
                passenger.getFirstName(),
                passenger.getLastName());
    }
}
