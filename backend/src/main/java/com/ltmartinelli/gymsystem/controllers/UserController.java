package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.UserDTO;
import com.ltmartinelli.gymsystem.dto.UserMinDTO;
import com.ltmartinelli.gymsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/me")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<UserDTO> getMe(){
        return ResponseEntity.ok(service.getMe());
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<UserMinDTO>> searchByName(@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable) {
        return ResponseEntity.ok(service.searchByName(name, pageable));
    }
}
