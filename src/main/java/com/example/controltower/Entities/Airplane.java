package com.example.controltower.Entities;

import jakarta.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String airplaneId;
    private String code;

    @ManyToOne
    @JoinColumn(name = "airport_Id")
    private Airport airport;

    public String getAirplaneId() {
        return airplaneId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
