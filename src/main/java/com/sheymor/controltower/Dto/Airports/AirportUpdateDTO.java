package com.sheymor.controltower.Dto.Airports;


import com.sheymor.controltower.Validations.Customs.CustomNotNull;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Airport}
 */
public record AirportUpdateDTO(
        @CustomNotNull String name,
        @CustomNotNull String city,
        @CustomNotNull String country
) {
}
