package com.ABCfitness.ClassBooking.Exceptions;

import com.ABCfitness.ClassBooking.DTOs.ErrorResponse;
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
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        ErrorResponse errorResponse = new ErrorResponse("ValidationError", "Validation failed for one or more fields.");
        errorResponse.setDetails(errors); // Assuming 'details' is a field in ErrorResponse for additional information.

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    // Handle custom exceptions for wrong dates
    @ExceptionHandler(WrongDateException.class)
    public ResponseEntity<ErrorResponse> handleWrongDateException(WrongDateException ex) {
        ErrorResponse errorResponse = new ErrorResponse("WrongDateException", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    //Handle custom exceptions for class not found
    @ExceptionHandler(ClassesNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClassNotFoundException(ClassesNotFoundException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse("ClassesNotFound", ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    //Handle custom exceptions for invalid participation date
    @ExceptionHandler(InvalidParticipationDateException.class)
    public ResponseEntity<ErrorResponse> handleInvalidParticipationException(InvalidParticipationDateException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse("InvalidParticipationDate", ex.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    //Handle custom exceptions for Capacity exceeded
    @ExceptionHandler(CapacityExceededException.class)
    public ResponseEntity<ErrorResponse> handleCapacityExceededException(CapacityExceededException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse("CapacityExceeded", ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    // Handle custom exceptions for duplicate classes
    @ExceptionHandler(ClassAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleClassAlreadyExistsException(ClassAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ClassAlreadyExists", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT); // 409 Conflict
    }

    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("InternalServerError", "An unexpected error occurred: " + ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

