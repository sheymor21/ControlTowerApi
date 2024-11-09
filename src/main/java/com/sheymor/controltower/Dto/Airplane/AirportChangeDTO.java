package com.sheymor.controltower.Dto.Airplane;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Airplane}
 */
public record AirportChangeDTO(
        @ValidAirportCodePresent String airportCode,
        @ValidAirplaneCodePresent String airplaneCode
) {
}
