package com.ABCfitness.ClassBooking.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.*;


public class ClassDTO {
    @NotBlank(message = "Class name cannot be blank.")
    private String name;

    @NotNull(message = "Start date is required.")
    private LocalDate startDate;

    @NotNull(message = "End date is required.")
    @Future(message = "End date must be in the future.")
    private LocalDate endDate;

    @NotNull(message = "Start time is required.")
    private LocalTime startTime;

    @Positive(message = "Duration must be greater than 0 minutes.")
    private int duration;

    @Min(value = 1, message = "Capacity must be at least 1.")
    private int capacity;

    public ClassDTO(String name, LocalDate startDate, LocalDate endDate, LocalTime startTime, int duration, int capacity) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.duration = duration;
        this.capacity = capacity;
    }

    public @NotBlank(message = "Class name cannot be blank.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Class name cannot be blank.") String name) {
        this.name = name;
    }

    public @NotNull(message = "Start date is required.") LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull(message = "Start date is required.") LocalDate startDate) {
        this.startDate = startDate;
    }

    public @NotNull(message = "End date is required.") @Future(message = "End date must be in the future.") LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotNull(message = "End date is required.") @Future(message = "End date must be in the future.") LocalDate endDate) {
        this.endDate = endDate;
    }

    public @NotNull(message = "Start time is required.") LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotNull(message = "Start time is required.") LocalTime startTime) {
        this.startTime = startTime;
    }

    @Positive(message = "Duration must be greater than 0 minutes.")
    public int getDuration() {
        return duration;
    }

    public void setDuration(@Positive(message = "Duration must be greater than 0 minutes.") int duration) {
        this.duration = duration;
    }

    @Min(value = 1, message = "Capacity must be at least 1.")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(@Min(value = 1, message = "Capacity must be at least 1.") int capacity) {
        this.capacity = capacity;
    }
}

