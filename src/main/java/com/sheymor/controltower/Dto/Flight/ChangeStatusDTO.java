package com.sheymor.controltower.Dto.Flight;

public class ChangeStatusDTO {
    private String flightId;
    private Status status;

    public String getFlightId() {
        return flightId;
    }

    public String getStatus() {
        return status.toString();
    }

    public enum Status {
        CANCELLED,
        COMPLETED,
        ONGOING,
        WAITING

    }
}
