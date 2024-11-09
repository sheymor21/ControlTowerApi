package com.sheymor.controltower.Entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Boolean boarded;

    @ManyToOne()
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @Enumerated(EnumType.STRING)
    @Setter(AccessLevel.NONE)
    private CabinClass cabinClass;

    public void setCabinClass(String cabinClass) {

        StringBuilder builder = new StringBuilder();
        builder.append("Invalid Cabin Class, only accepted [First,Second,Economic,Business]");
        int n = 0;
        for (var cabin : FlightTicket.CabinClass.values()) {
            if (cabin.name().equals(cabinClass.toUpperCase())) {
                this.cabinClass = cabin;
            }

            if (n == 0) {
                builder.append(" ").append(cabin.name());
                n++;
            } else {
                builder.append(",").append(cabin.name());
            }
        }
        throw new RuntimeException(builder.toString());
    }

    public enum CabinClass {
        FIRST,
        SECOND,
        ECONOMY,
        BUSINESS,
    }

}
