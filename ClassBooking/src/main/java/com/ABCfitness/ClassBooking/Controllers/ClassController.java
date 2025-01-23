package com.ABCfitness.ClassBooking.Controllers;


import com.ABCfitness.ClassBooking.DTOs.ClassDTO;
import com.ABCfitness.ClassBooking.Models.ClassEntity;
import com.ABCfitness.ClassBooking.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<ClassEntity> createClass(@Valid @RequestBody ClassDTO classDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(classService.createClass(classDTO));
    }
}

