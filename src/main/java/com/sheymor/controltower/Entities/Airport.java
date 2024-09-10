package com.sheymor.controltower.Entities;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String airportId;
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private String code;

    @OneToMany(mappedBy = "airport",cascade = CascadeType.ALL)
    private Set<Airplane> airplanes;

    @OneToMany(mappedBy = "airport",cascade = CascadeType.ALL)
    private Set<Flights> flights;

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportId() {
        return airportId;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
