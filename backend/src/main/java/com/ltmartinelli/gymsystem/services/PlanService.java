package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.PlanDTO;
import com.ltmartinelli.gymsystem.entities.Plan;
import com.ltmartinelli.gymsystem.entities.Unit;
import com.ltmartinelli.gymsystem.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {

    @Autowired
    private PlanRepository repository;

    @Transactional(readOnly = true)
    public List<PlanDTO> findAll(){
        return repository.findAll().stream().map(plan -> new PlanDTO(plan)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Plan findById(Long id) {
        return repository.getReferenceById(id);
    }

}
