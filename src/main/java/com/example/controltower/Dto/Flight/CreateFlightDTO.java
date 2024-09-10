package com.example.controltower.Dto.Flight;

import java.util.Date;

public class CreateFlightDTO {
    private String airplaneCode;
    private String airportHomeCode;
    private Date departureTime;
    private Date arrivalTime;
    private String airportDestinationCode;

    public String getAirplaneCode() {
        return airplaneCode;
    }

    public String getAirportHomeCode() {
        return airportHomeCode;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getAirportDestinationCode() {
        return airportDestinationCode;
    }
}
