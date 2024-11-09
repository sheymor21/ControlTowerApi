package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Repositories.AirplaneRepository;
import com.sheymor.controltower.Validations.Annotations.ValidAirplaneCodeNotPresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AirplaneCodeNotPresentValidation implements ConstraintValidator<ValidAirplaneCodeNotPresent, String> {
    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneCodeNotPresentValidation(AirplaneRepository airplaneRepository) {

        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return airplaneRepository.findByCode(s).isEmpty();
    }
}
