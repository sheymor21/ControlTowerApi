package com.sheymor.controltower.Validations.Annotations;

import com.sheymor.controltower.Validations.AirportCodeNotPresentValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AirportCodeNotPresentValidation.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAirportCodeNotPresent {
    String message() default "Invalid airport code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
