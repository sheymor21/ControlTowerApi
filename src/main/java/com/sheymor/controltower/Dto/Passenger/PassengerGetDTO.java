package com.sheymor.controltower.Dto.Passenger;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Passenger}
 */
public record PassengerGetDTO(
        String id,
        String firstName,
        String lastName
) {
}
