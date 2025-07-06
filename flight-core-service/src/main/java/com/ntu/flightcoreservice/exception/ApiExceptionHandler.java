package com.ntu.flightcoreservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleIlException(CustomException e) {
        return new ResponseEntity<>(e.getErrorDetails(), HttpStatus.BAD_REQUEST);
    }

}