package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Repositories.PassengerRepository;
import com.sheymor.controltower.Validations.Annotations.ValidPassengerId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class PassengerIdValidation implements ConstraintValidator<ValidPassengerId, String> {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerIdValidation(PassengerRepository passengerRepository)
    {
        this.passengerRepository = passengerRepository;
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return passengerRepository.findById(s).isPresent();
    }
}
