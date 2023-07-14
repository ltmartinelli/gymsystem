package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.UnitDTO;
import com.ltmartinelli.gymsystem.entities.Unit;
import com.ltmartinelli.gymsystem.repositories.UnitRepository;
import com.ltmartinelli.gymsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitService {

    @Autowired
    private UnitRepository repository;

    @Transactional(readOnly = true)
    public List<UnitDTO> findAll() {
        return repository.findAll().stream().map(unit -> new UnitDTO(unit)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Unit findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }
}
