package com.a2z.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleResourceNotFoundException(RuntimeException e) {
        return new ResponseEntity<>(" Employee Not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
