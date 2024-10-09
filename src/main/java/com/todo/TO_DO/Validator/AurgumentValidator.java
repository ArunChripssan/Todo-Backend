package com.todo.TO_DO.Validator;

import com.todo.TO_DO.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AurgumentValidator {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExeption (MethodArgumentNotValidException exception){
        Map<String, String> error = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((errors -> {
            error.put(errors.getField(), errors.getDefaultMessage());
        } ));
        return error;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public String RecourdNotFoundException(RecordNotFoundException ex){
        return ex.getMessage();
    }
}
