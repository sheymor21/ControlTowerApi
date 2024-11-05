package com.sheymor.controltower.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter @Setter
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
    private Set<Flight> flights;

}
