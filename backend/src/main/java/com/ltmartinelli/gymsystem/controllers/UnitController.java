package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.UnitDTO;
import com.ltmartinelli.gymsystem.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/units")
public class UnitController {

    @Autowired
    private UnitService service;

    //Returns all existing Units and their addresses.
    @GetMapping
    public ResponseEntity<List<UnitDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
