package com.log.pp2.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionalHandler {
    String message;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodException(Exception ex, BindingResult br){
        FieldError fr = br.getFieldError();
        return new ResponseEntity<>("Method Not Found "+ (fr != null ? fr.getDefaultMessage() : null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constarintException(Exception ex,BindingResult br){
        FieldError fr = br.getFieldError();
        return  new ResponseEntity<>("Constraints voileted "+ (fr != null ? fr.getDefaultMessage() : null),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> idNotFoundException(IdNotFoundException ex){
        message = ex.getMessage() + " at time "+ex.getTimestamp() ;
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
}
