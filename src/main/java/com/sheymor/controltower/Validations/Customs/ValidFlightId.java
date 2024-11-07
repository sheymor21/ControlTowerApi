package com.sheymor.controltower.Validations.Customs;


import com.sheymor.controltower.Validations.FlighIdValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FlighIdValidation.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.FIELD, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFlightId {
    String message() default "Invalid flight id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
