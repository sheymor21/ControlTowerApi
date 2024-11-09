package com.sheymor.controltower.Dto.Airports;


import com.sheymor.controltower.Validations.Annotations.CustomNotNull;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Airport}
 */
public record AirportUpdateDTO(
        @CustomNotNull String name,
        @CustomNotNull String city,
        @CustomNotNull String country
) {
}
