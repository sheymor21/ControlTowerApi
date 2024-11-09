package com.sheymor.controltower.Validations.Customs;

import com.sheymor.controltower.Validations.DateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateValidation.class)
@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {

    String message() default "Invalid Date format, use yyyy/MM/dd-HH:mm";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
