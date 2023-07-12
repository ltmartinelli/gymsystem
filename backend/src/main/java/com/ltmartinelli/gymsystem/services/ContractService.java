package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.ContractDTO;
import com.ltmartinelli.gymsystem.entities.Contract;
import com.ltmartinelli.gymsystem.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public ContractDTO findByUser(Long clientId) {
        Contract contract = repository.findByUser(clientId);
        authService.validateSelfOrAdmin(contract.getUser().getId());
        return new ContractDTO(contract);
    }
}
