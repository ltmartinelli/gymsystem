package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.WorkoutDTO;
import com.ltmartinelli.gymsystem.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService service;

    //Returns a specific workout and its exercises
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<WorkoutDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

    //Returns all workouts of a specific user
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<Page<WorkoutDTO>> findByUser(Pageable pageable) {
        return ResponseEntity.ok().body(service.findByUser(pageable));
    }

    //Allows user to insert a new workout for their profile
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<WorkoutDTO> insert(@Valid @RequestBody WorkoutDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //Allows user to update an existing workout
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<WorkoutDTO> update(@Valid @RequestBody WorkoutDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    //Allows user to delete a specific workout
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
