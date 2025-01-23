package com.ABCfitness.ClassBooking.Services;


import com.ABCfitness.ClassBooking.DTOs.ClassDTO;
import com.ABCfitness.ClassBooking.Exceptions.ClassAlreadyExistsException;
import com.ABCfitness.ClassBooking.Exceptions.WrongDateException;
import com.ABCfitness.ClassBooking.Models.ClassEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final List<ClassEntity> classes = new ArrayList<>();
    private long idCounter = 1;

    public ClassEntity createClass(ClassDTO classDTO) {
        if (classDTO.getStartDate().isAfter(classDTO.getEndDate())) {
            throw new WrongDateException("Start date cannot be after end date.");
        }
        boolean exists = classes.stream()
                .anyMatch(c -> c.getName().equalsIgnoreCase(classDTO.getName()) &&
                        c.getStartDate().isEqual(classDTO.getStartDate()));
        if (exists) {
            throw new ClassAlreadyExistsException("A class with the same name already exists for the day.");
        }

        ClassEntity classEntity = new ClassEntity(idCounter++,classDTO.getName(),classDTO.getStartDate(),classDTO.getEndDate(),classDTO.getStartTime(),classDTO.getDuration(),classDTO.getCapacity());
       classes.add(classEntity);
        return classEntity;
    }

    public Optional<ClassEntity> getClassById(Long id) {
        return classes.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
}

