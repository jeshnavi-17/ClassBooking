package com.ABCfitness.ClassBooking.Models;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingEntity {
    private Long id;

    @NotBlank
    private String memberName;

    @Future
    @NotNull
    private LocalDate participationDate;

    @NotNull
    private ClassEntity classEntity;

    public BookingEntity(Long id, String memberName, LocalDate participationDate, ClassEntity classEntity) {
        this.id = id;
        this.memberName = memberName;
        this.participationDate = participationDate;
        this.classEntity = classEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getMemberName() {
        return memberName;
    }

    public void setMemberName(@NotBlank String memberName) {
        this.memberName = memberName;
    }

    public @Future @NotNull LocalDate getParticipationDate() {
        return participationDate;
    }

    public void setParticipationDate(@Future @NotNull LocalDate participationDate) {
        this.participationDate = participationDate;
    }

    public @NotNull ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(@NotNull ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}


