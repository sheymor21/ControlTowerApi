package com.sheymor.controltower.Validations.Annotations;

import com.sheymor.controltower.Validations.PassengerLimitValidation;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PassengerLimitValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.PARAMETER})
public @interface ValidPassengerLimit {
    String message() default "Flight are full or not available";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
