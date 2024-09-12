package com.sheymor.controltower.Dto.Flight;

import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;

import java.util.Date;

public class CreateFlightDTO {
    @ValidAirplaneCodePresent
    private String airplaneCode;
    @ValidAirportCodePresent(message = "Invalid airportHome Code")
    private String airportHomeCode;
    @ValidAirportCodePresent(message = "Invalid airportDestination Code")
    private String airportDestinationCode;
    private Date departureTime;
    private Date arrivalTime;

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
