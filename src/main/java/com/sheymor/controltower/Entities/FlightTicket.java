package com.sheymor.controltower.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Boolean boarded;

    @ManyToOne()
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name ="passenger_id")
    private Passenger passenger;

    @Enumerated(EnumType.STRING)
    private CabinClass cabinClass;

    public enum CabinClass {
        FirstClass,
        SecondClass,
        EconomicClass,
    }

}
