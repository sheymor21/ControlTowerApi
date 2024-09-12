package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Repositories.FlightRepository;
import com.sheymor.controltower.Validations.Customs.ValidFlightId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class FlighIdValidation implements ConstraintValidator<ValidFlightId, String> {
    private final FlightRepository flightRepository;

    @Autowired
    public FlighIdValidation(FlightRepository flightRepository) {

        this.flightRepository = flightRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return flightRepository.findById(s).isPresent();
    }
}
