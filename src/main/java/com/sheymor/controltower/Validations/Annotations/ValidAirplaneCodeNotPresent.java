package com.sheymor.controltower.Validations.Annotations;

import com.sheymor.controltower.Validations.AirplaneCodeNotPresentValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AirplaneCodeNotPresentValidation.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAirplaneCodeNotPresent {
    String message() default "Invalid airplane code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
