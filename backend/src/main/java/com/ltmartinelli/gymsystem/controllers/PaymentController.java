package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.PaymentDTO;
import com.ltmartinelli.gymsystem.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    PaymentService service;

    //Returns a specific payment by providing an ID
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<PaymentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    //Allows admin to update a payment's Status and payment date.
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PaymentDTO> update(@PathVariable Long id, @Valid @RequestBody PaymentDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
