package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Validations.Annotations.ValidDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.logging.log4j.util.Strings;



@Slf4j
public class DateValidation implements ConstraintValidator<ValidDate, String> {

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null || date.trim().equals(Strings.EMPTY)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Date cannot be null").addConstraintViolation();
            return false;
        }
        DateValidator dateValidation = DateValidator.getInstance();
        return dateValidation.isValid(date,"yyyy/MM/dd-HH:mm");

    }
}
