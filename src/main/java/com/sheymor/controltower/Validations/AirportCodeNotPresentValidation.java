package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Repositories.AirportRepository;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodeNotPresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AirportCodeNotPresentValidation implements ConstraintValidator<ValidAirportCodeNotPresent, String> {
    private final AirportRepository airportRepository;

    @Autowired
    public AirportCodeNotPresentValidation(AirportRepository airportRepository) {

        this.airportRepository = airportRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return airportRepository.findByCode(s).isEmpty();
    }
}
