package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.ContractDTO;
import com.ltmartinelli.gymsystem.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contracts")
public class ContractController {

    @Autowired
    private ContractService service;

    @GetMapping(value = "/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<ContractDTO> findByUser(@PathVariable Long clientId) {
        return ResponseEntity.ok(service.findByUser(clientId));
    }
}
