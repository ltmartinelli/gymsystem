package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.PaymentDTO;
import com.ltmartinelli.gymsystem.entities.Payment;
import com.ltmartinelli.gymsystem.entities.Workout;
import com.ltmartinelli.gymsystem.repositories.PaymentRepository;
import com.ltmartinelli.gymsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;

    @Autowired
    AuthService authService;

    @Transactional(readOnly = true)
    public PaymentDTO findById(Long id) {
        Payment payment = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        authService.validateSelfOrAdmin(payment.getContract().getUser().getId());
        return new PaymentDTO(payment);
    }
}
