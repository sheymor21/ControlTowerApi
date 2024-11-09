package com.sheymor.controltower.Validations.Customs;

import com.sheymor.controltower.Validations.CabinClassValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CabinClassValidation.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCabinClass {

    String message() default "Invalid Cabin Class, only accepted [First,Second,Economic,Business]";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

