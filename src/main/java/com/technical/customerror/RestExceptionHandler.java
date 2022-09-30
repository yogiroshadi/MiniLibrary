package com.technical.customerror;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    //this is global handler exception

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exc) {
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exc) {
        Map<String, String> errors = new HashMap<>();

        List<ObjectError> errorObject = exc.getBindingResult().getAllErrors();

        for (ObjectError objectError : errorObject) {
            if (objectError instanceof FieldError) {
                String fieldName = ((FieldError) objectError).getField();
                String fieldMessage = objectError.getDefaultMessage();
                errors.put(fieldName, fieldMessage);
            } else if(objectError instanceof ObjectError){
                String fieldName =  objectError.getObjectName();
                String fieldMessage = objectError.getDefaultMessage();
                errors.put(fieldName, fieldMessage);

            }

        }
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage(errors);
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);

    }
}
