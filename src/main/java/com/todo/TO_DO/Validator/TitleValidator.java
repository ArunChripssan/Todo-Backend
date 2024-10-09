package com.todo.TO_DO.Validator;

import com.todo.TO_DO.Validation.TitleValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy = TitleValidation.class)
public @interface TitleValidator {
    public String message() default "Title Should be min 3 and max 20 character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
