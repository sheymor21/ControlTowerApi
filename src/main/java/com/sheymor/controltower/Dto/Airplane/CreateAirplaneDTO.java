package com.sheymor.controltower.Dto.Airplane;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodeNotPresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

public class CreateAirplaneDTO {
    @ValidAirplaneCodeNotPresent
    private String code;
    @ValidAirportCodePresent
    private String airportCode;

    public String getCode() {
        return code;
    }

    public String getAirportCode() {
        return airportCode;
    }
}
