package com.sheymor.controltower.Dto.Passenger;

/**
 * DTO for {@link com.sheymor.controltower.Entities.Passenger}
 */
public record PassengerUpdateDTO (
        String firstName,
        String lastName
) {
}
