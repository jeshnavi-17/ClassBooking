package com.ABCfitness.ClassBooking.Services;


import com.ABCfitness.ClassBooking.DTOs.BookingDTO;
import com.ABCfitness.ClassBooking.Exceptions.CapacityExceededException;
import com.ABCfitness.ClassBooking.Exceptions.ClassesNotFoundException;
import com.ABCfitness.ClassBooking.Exceptions.InvalidParticipationDateException;
import com.ABCfitness.ClassBooking.Exceptions.WrongDateException;
import com.ABCfitness.ClassBooking.Models.BookingEntity;
import com.ABCfitness.ClassBooking.Models.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final List<BookingEntity> bookings = new ArrayList<>();

    @Autowired
    private ClassService classService;
    private long idCounter = 1;


    public BookingEntity createBooking(BookingDTO bookingDTO) {
        Optional<ClassEntity> classOpt = classService.getClassById(bookingDTO.getClassId());
        if (classOpt.isEmpty()) {
            throw new ClassesNotFoundException("Class not found");
        }

        ClassEntity classEntity = classOpt.get();
        if(bookingDTO.getParticipationDate().isBefore(classEntity.getStartDate()) ||
                bookingDTO.getParticipationDate().isAfter(classEntity.getEndDate()))
        {
            throw new InvalidParticipationDateException("Participation Date should be between"+ classEntity.getStartDate()+"and"+ classEntity.getEndDate());
        }
        long bookingCount = bookings.stream()
                .filter(b -> b.getClassEntity().getId().equals(classEntity.getId()) &&
                        b.getParticipationDate().equals(bookingDTO.getParticipationDate()))
                .count();

        if (bookingCount >= classEntity.getCapacity()) {
            throw new CapacityExceededException("Class capacity limit reached  for class: " + classEntity.getName() +" on " +bookingDTO.getParticipationDate() );
        }

        BookingEntity booking = new BookingEntity(idCounter++,bookingDTO.getMemberName(),bookingDTO.getParticipationDate(),classEntity);
        bookings.add(booking);
        return booking;
    }

    public List<BookingEntity> searchBookings(String memberName, LocalDate startDate, LocalDate endDate) {
        if(startDate != null && endDate!=null && startDate.isAfter(endDate))
        {
            throw new WrongDateException("Start date cannot be after end date.");
        }
        return bookings.stream()
                .filter(b -> (memberName == null || b.getMemberName().equalsIgnoreCase(memberName)) &&
                        (startDate == null || !b.getParticipationDate().isBefore(startDate)) &&
                        (endDate == null || !b.getParticipationDate().isAfter(endDate)))
                .collect(Collectors.toList());
    }
}

