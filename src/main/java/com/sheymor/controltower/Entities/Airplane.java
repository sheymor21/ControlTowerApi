package com.sheymor.controltower.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String airplaneId;
    private String model;
    private String company;
    private int passengerCapacity;
    private String code;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @OneToMany(mappedBy = "airplane",cascade = CascadeType.ALL)
    private Set<Flight> flights;
}
