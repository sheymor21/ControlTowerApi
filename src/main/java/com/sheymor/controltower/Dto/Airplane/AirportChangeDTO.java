package com.sheymor.controltower.Dto.Airplane;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodeNotPresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

public record AirportChangeDTO(
        @ValidAirportCodePresent String airportCode,
        @ValidAirplaneCodePresent String airplaneCode
) {
}
