package com.ABCfitness.ClassBooking.DTOs;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


public class BookingDTO {
    @NotBlank(message = "Member name cannot be blank.")
    private String memberName;

    @NotNull(message = "Class ID cannot be null.")
    private Long classId;

    @NotNull(message = "Participation date cannot be null.")
    @Future(message = "Participation date must be in the future.")
    private LocalDate participationDate;

    public BookingDTO(String memberName, Long classId, LocalDate participationDate) {
        this.memberName = memberName;
        this.classId = classId;
        this.participationDate = participationDate;
    }

    public @NotBlank(message = "Member name cannot be blank.") String getMemberName() {
        return memberName;
    }

    public void setMemberName(@NotBlank(message = "Member name cannot be blank.") String memberName) {
        this.memberName = memberName;
    }

    public @NotNull(message = "Class ID cannot be null.") Long getClassId() {
        return classId;
    }

    public void setClassId(@NotNull(message = "Class ID cannot be null.") Long classId) {
        this.classId = classId;
    }

    public @NotNull(message = "Participation date cannot be null.") @Future(message = "Participation date must be in the future.") LocalDate getParticipationDate() {
        return participationDate;
    }

    public void setParticipationDate(@NotNull(message = "Participation date cannot be null.") @Future(message = "Participation date must be in the future.") LocalDate participationDate) {
        this.participationDate = participationDate;
    }
}
