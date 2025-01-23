package com.ABCfitness.ClassBooking.Exceptions;

public class CapacityExceededException extends RuntimeException {
    public CapacityExceededException(String message) {
        super(message);
    }
}
