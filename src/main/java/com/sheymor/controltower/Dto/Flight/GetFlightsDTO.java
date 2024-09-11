package com.sheymor.controltower.Dto.Flight;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GetFlightsDTO {
    private String flightId;
    private String airplaneCode;
    private String airportHomeCode;
    private String airportDestinationCode;
    private Date departureTime;
    private Date arrivalTime;
    private String status;

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    public void setAirportHomeCode(String airportHomeCode) {
        this.airportHomeCode = airportHomeCode;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setAirportDestinationCode(String airportDestinationCode) {
        this.airportDestinationCode = airportDestinationCode;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
