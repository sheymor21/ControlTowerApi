package com.sheymor.controltower.Dto.Airplane;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Airplane}
 */
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
