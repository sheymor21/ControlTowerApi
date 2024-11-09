package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Repositories.AirplaneRepository;
import com.sheymor.controltower.Validations.Annotations.ValidAirplaneCodePresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AirplaneCodePresentValidation implements ConstraintValidator<ValidAirplaneCodePresent, String> {
    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneCodePresentValidation(AirplaneRepository airplaneRepository) {

        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return airplaneRepository.findByCode(s).isPresent();
    }
}
