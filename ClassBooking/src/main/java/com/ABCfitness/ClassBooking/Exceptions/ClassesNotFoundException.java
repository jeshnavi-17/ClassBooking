package com.ABCfitness.ClassBooking.Exceptions;

public class ClassesNotFoundException extends RuntimeException {
    public ClassesNotFoundException(String message) {
        super(message);
    }
}
