package com.sheymor.controltower.Dto.Airports;


/**
 * DTO for {@link com.sheymor.controltower.Entities.Airport}
 */
public record AirportGetDTO(
        String airportName,
        String airportCity,
        String airportCountry,
        String code
) {

}