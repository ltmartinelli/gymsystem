package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.WorkoutDTO;
import com.ltmartinelli.gymsystem.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkoutDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

}
