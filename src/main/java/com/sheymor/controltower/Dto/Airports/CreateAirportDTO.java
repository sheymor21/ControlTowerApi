package com.sheymor.controltower.Dto.Airports;

import com.sheymor.controltower.Validations.Customs.ValidAirportCodeNotPresent;

public class CreateAirportDTO {
    private String name;
    @ValidAirportCodeNotPresent
    private String code;
    private String city;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
