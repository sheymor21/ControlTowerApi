package com.sheymor.controltower.Dto.Flight;

import com.sheymor.controltower.Validations.Customs.ValidFlightId;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Flight}
 */
public record FlightStatusDTO(
        @ValidFlightId String flightId,
        Status status
) {

    public enum Status {
        CANCELLED,
        COMPLETED,
        ONGOING,
        WAITING

    }
}
