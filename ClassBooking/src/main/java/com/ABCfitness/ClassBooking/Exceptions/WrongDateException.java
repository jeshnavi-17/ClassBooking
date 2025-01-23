package com.ABCfitness.ClassBooking.Exceptions;

public class WrongDateException extends RuntimeException {
    public WrongDateException(String message) {
        super(message);
    }
}
