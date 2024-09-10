package com.example.controltower.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String airplaneId;
    private String code;

    @ManyToOne
    @JoinColumn(name = "airport_Id")
    private Airport airport;

    @OneToMany(mappedBy = "airplane",cascade = CascadeType.ALL)
    private Set<Flights> flights;

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
