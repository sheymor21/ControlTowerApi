package com.sheymor.controltower.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter @Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String flightId;
    private String airplaneCode;
    private String airportHomeCode;
    private Date departureTime;
    private Date arrivalTime;
    private String airportDestinationCode;

    @Enumerated(EnumType.STRING)
    private Status status;



    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @OneToMany(mappedBy = "flight",cascade = CascadeType.ALL)
    private Set<FlightTicket> flightPassenger;

    public enum Status {
        CANCELLED,
        COMPLETED,
        ONGOING,
        WAITING

    }

}
