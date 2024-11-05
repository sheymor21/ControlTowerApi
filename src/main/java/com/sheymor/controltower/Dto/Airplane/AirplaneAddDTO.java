package com.sheymor.controltower.Dto.Airplane;

import com.sheymor.controltower.Validations.Customs.ValidAirportCodeNotPresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

public record AirplaneAddDTO(
        @ValidAirportCodeNotPresent String code,
        @ValidAirportCodePresent String airportCode,
        String model,
        String company,
        int passengerCapacity
) {

}
