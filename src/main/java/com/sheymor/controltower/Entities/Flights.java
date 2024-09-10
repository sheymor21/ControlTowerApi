package com.sheymor.controltower.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String flightId;
    private String airplaneCode;
    private String airportHomeCode;
    private Date departureTime;
    private Date arrivalTime;
    private String status;
    private String airportDestinationCode;

    @ManyToOne
    @JoinColumn(name = "airplane_Id")
    private Airplane airplane;
    @ManyToOne
    @JoinColumn(name = "airport_Id")
    private Airport airport;

    public String getFlightId() {
        return flightId;
    }

    public String getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    public String getAirportHomeCode() {
        return airportHomeCode;
    }

    public void setAirportHomeCode(String airportCode) {
        this.airportHomeCode = airportCode;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAirportDestinationCode() {
        return airportDestinationCode;
    }

    public void setAirportDestinationCode(String aiportDestinationCode) {
        this.airportDestinationCode = aiportDestinationCode;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
