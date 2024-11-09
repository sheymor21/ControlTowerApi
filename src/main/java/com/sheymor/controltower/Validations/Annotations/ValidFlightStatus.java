package com.sheymor.controltower.Validations.Annotations;

import com.sheymor.controltower.Validations.FlightStatusValidation;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FlightStatusValidation.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFlightStatus {
    String message() default "Invalid Flight Status, only accepted [Completed,Cancelled,Ongoing,Waiting]";
    Class<?>[] groups() default {};
    Class<? extends java.lang.annotation.Annotation>[] payload() default {};
}
