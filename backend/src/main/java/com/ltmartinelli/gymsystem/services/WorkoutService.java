package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.WorkoutDTO;
import com.ltmartinelli.gymsystem.entities.Workout;
import com.ltmartinelli.gymsystem.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository repository;

    @Transactional(readOnly = true)
    public WorkoutDTO findById(Long id) {
        Workout workout = repository.getReferenceById(id);
        return new WorkoutDTO(workout);
    }

}
