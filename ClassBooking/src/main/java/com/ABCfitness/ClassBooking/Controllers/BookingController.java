package com.ABCfitness.ClassBooking.Controllers;


import com.ABCfitness.ClassBooking.DTOs.BookingDTO;
import com.ABCfitness.ClassBooking.Models.BookingEntity;
import com.ABCfitness.ClassBooking.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingEntity> createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(bookingDTO));
    }

    @GetMapping
    public ResponseEntity<List<BookingEntity>> searchBookings(
            @RequestParam(required = false) String memberName,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {

        LocalDate sDate=null, eDate=null;
        if(startDate != null)
        {
             sDate = LocalDate.parse(startDate);
        }
        if(endDate != null)
        {
            eDate = LocalDate.parse(endDate);
        }
        return ResponseEntity.ok(bookingService.searchBookings(memberName, sDate, eDate));
    }
}

