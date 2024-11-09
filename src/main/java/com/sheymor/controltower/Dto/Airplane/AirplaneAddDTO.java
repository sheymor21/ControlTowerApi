package com.sheymor.controltower.Dto.Airplane;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodeNotPresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Airplane}
 */
public record AirplaneAddDTO(
        @ValidAirplaneCodeNotPresent String code,
        @ValidAirportCodePresent String airportCode,
        String model,
        String company,
        int passengerCapacity
) {

}
