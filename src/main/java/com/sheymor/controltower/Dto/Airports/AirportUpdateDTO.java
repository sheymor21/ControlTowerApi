package com.sheymor.controltower.Dto.Airports;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Airport}
 */
public record AirportUpdateDTO(
        String name,
        String city,
        String country
) {
}
