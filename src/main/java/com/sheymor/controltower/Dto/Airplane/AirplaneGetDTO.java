package com.sheymor.controltower.Dto.Airplane;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Airplane}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AirplaneGetDTO(
        String code,
        String model,
        String company,
        int passengerCapacity,
        String airportCode,
        String airportName,
        String airportCity,
        String airportCountry
) {

}
