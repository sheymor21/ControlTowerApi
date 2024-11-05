package com.sheymor.controltower.Dto.Airports;

import com.sheymor.controltower.Validations.Customs.ValidAirportCodeNotPresent;

public record AirportAddDTO(
        String name,
        @ValidAirportCodeNotPresent String code,
        String city,
        String country
) {
}
