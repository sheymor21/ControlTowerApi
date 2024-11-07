package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Entities.FlightTicket;
import com.sheymor.controltower.Validations.Customs.ValidCabinClass;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CabinClassValidation implements ConstraintValidator<ValidCabinClass, String> {

    @Override
    public boolean isValid(String cabinClass, ConstraintValidatorContext constraintValidatorContext) {
        for (var s : FlightTicket.CabinClass.values()) {
            if (s.name().equals(cabinClass)) {
                return true;
            }
        }
        return false;
    }

}
