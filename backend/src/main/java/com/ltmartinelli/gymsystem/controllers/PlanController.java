package com.ltmartinelli.gymsystem.controllers;

import com.ltmartinelli.gymsystem.dto.PlanDTO;
import com.ltmartinelli.gymsystem.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/plans")
public class PlanController {

    @Autowired
    private PlanService service;

    //Returns all existing Plans and their details
    @GetMapping
    public ResponseEntity<List<PlanDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
