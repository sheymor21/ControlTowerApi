package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Repositories.AirportRepository;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AirportCodePresentValidation implements ConstraintValidator<ValidAirportCodePresent, String> {
    private final AirportRepository airportRepository;

    @Autowired
    public AirportCodePresentValidation(AirportRepository airportRepository) {

        this.airportRepository = airportRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return airportRepository.findByCode(s).isPresent();
    }
}
