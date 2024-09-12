package com.sheymor.controltower.Dto.Flight;

import com.sheymor.controltower.Validations.Customs.ValidFlightId;

public class ChangeStatusDTO {
    @ValidFlightId
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
