package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.WorkoutDTO;
import com.ltmartinelli.gymsystem.entities.Workout;
import com.ltmartinelli.gymsystem.repositories.WorkoutRepository;
import com.ltmartinelli.gymsystem.services.exceptions.ResourceNotFoundException;
import org.hibernate.mapping.List;
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
        Workout workout = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new WorkoutDTO(workout);
    }

}
