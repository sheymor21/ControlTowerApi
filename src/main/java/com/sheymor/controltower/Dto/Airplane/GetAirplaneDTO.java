package com.sheymor.controltower.Dto.Airplane;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GetAirplaneDTO {
    private String code;
    private String airportCode;
    private String airportName;
    private String airportCity;
    private String airportCountry;

    public void setCode(String code) {
        this.code = code;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }
}
