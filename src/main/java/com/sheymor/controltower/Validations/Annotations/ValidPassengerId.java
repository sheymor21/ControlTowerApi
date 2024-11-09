package com.sheymor.controltower.Validations.Annotations;

import com.sheymor.controltower.Validations.PassengerIdValidation;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PassengerIdValidation.class)
@Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassengerId {
    String message() default "Invalid passenger id";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
