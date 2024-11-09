package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Validations.Annotations.CustomNotNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.logging.log4j.util.Strings;

public class NotNullValidation implements ConstraintValidator<CustomNotNull, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && !s.trim().equals(Strings.EMPTY);
    }
}
