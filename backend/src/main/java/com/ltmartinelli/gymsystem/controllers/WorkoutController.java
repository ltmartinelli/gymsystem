package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.WorkoutDTO;
import com.ltmartinelli.gymsystem.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService service;

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<WorkoutDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<Page<WorkoutDTO>> findByUser(Pageable pageable) {
        return ResponseEntity.ok().body(service.findByUser(pageable));
    }

}
