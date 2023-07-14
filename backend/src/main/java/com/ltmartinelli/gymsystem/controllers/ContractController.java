package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.ContractDTO;
import com.ltmartinelli.gymsystem.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/contracts")
public class ContractController {

    @Autowired
    private ContractService service;

    //Returns a Contract and its payments by Providing the Client's ID
    @GetMapping(value = "/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<ContractDTO> findByUser(@PathVariable Long clientId) {
        return ResponseEntity.ok(service.findByUser(clientId));
    }

    //Allows Admin to insert a new contract along with its payments into the Database
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ContractDTO> insert(@Valid @RequestBody ContractDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getClientId().toString() + dto.getUnitId().toString()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
