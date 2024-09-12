package com.sheymor.controltower.Dto.Airplane;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

public class ChangeAirportDTO {
    @ValidAirportCodePresent
    private String airportCode;
    @ValidAirplaneCodePresent()
    private String airplaneCode;

    public String getAirportCode() {
        return airportCode;
    }

    public String getAirplaneCode() {
        return airplaneCode;
    }
}
