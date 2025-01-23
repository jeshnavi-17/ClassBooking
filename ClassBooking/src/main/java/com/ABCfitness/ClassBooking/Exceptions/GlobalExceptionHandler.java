package com.ABCfitness.ClassBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle validation errors (e.g., @NotNull, @NotBlank, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Handle custom exceptions for wrong dates
    @ExceptionHandler(WrongDateException.class)
    public ResponseEntity<String> handleWrongDateException(WrongDateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //Handle custom exceptions for class not found
    @ExceptionHandler(ClassesNotFoundException.class)
    public ResponseEntity<String> handleClassNotFoundException(ClassesNotFoundException ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    //Handle custom exceptions for invalid participation date
    @ExceptionHandler(InvalidParticipationDateException.class)
    public ResponseEntity<String> handleInvalidParticipationException(InvalidParticipationDateException ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    //Handle custom exceptions for Capacity exceeded
    @ExceptionHandler(CapacityExceededException.class)
    public ResponseEntity<String> handleCapacityExceededException(CapacityExceededException ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    // Handle custom exceptions for duplicate classes
    @ExceptionHandler(ClassAlreadyExistsException.class)
    public ResponseEntity<String> handleClassAlreadyExistsException(ClassAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // 409 Conflict
    }

    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

