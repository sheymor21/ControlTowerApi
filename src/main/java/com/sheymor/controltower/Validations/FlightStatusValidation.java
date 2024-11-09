package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Entities.Flight;
import com.sheymor.controltower.Validations.Annotations.ValidFlightStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FlightStatusValidation implements ConstraintValidator<ValidFlightStatus, String> {
    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {

        for (var s : Flight.Status.values()) {
            if (s.name().equals(status.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
