package com.sheymor.controltower.Dto.Flight;

import com.sheymor.controltower.Validations.Annotations.ValidFlightId;
import com.sheymor.controltower.Validations.Annotations.ValidFlightStatus;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Flight}
 */
public record FlightStatusDTO(
        @ValidFlightId String flightId,
        @ValidFlightStatus String status
) {

}
