package com.sheymor.controltower.Validations.Annotations;

import com.sheymor.controltower.Validations.AirplaneCodePresentValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AirplaneCodePresentValidation.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAirplaneCodePresent {
    String message() default "Invalid airplane code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
