package com.sheymor.controltower.Dto.Airplane;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodeNotPresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

public record AirplaneAddDTO(
        @ValidAirplaneCodeNotPresent String code,
        @ValidAirportCodePresent String airportCode,
        String model,
        String company,
        int passengerCapacity
) {

}
