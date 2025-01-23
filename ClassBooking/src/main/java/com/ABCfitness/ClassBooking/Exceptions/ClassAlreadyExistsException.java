package com.ABCfitness.ClassBooking.Exceptions;

public class ClassAlreadyExistsException extends RuntimeException {
    public ClassAlreadyExistsException(String message) {
        super(message);
    }
}
