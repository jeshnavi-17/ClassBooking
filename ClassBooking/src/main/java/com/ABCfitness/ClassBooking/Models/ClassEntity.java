package com.ABCfitness.ClassBooking.Models;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;


public class ClassEntity {
    private Long id;

    @NotBlank
    private String name;

    @Future
    @NotNull
    private LocalDate startDate;

    @Future
    @NotNull
    private LocalDate endDate;

    @NotNull
    private LocalTime startTime;

    @Min(1)
    private int duration;

    @Min(1)
    private int capacity;

    public ClassEntity(Long id, String name, LocalDate startDate, LocalDate endDate, LocalTime startTime, int duration, int capacity) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.duration = duration;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Future @NotNull LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(@Future @NotNull LocalDate startDate) {
        this.startDate = startDate;
    }

    public @Future @NotNull LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(@Future @NotNull LocalDate endDate) {
        this.endDate = endDate;
    }

    public @NotNull LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotNull LocalTime startTime) {
        this.startTime = startTime;
    }

    @Min(1)
    public int getDuration() {
        return duration;
    }

    public void setDuration(@Min(1) int duration) {
        this.duration = duration;
    }

    @Min(1)
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(@Min(1) int capacity) {
        this.capacity = capacity;
    }
}


