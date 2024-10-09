package com.todo.TO_DO.Validation;

import com.todo.TO_DO.Validator.TitleValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TitleValidation implements ConstraintValidator<TitleValidator, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext arg){
        return name.length() > 2 && name.length() < 20;
    }
}
