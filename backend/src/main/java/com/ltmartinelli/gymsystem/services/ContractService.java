package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.ContractDTO;
import com.ltmartinelli.gymsystem.dto.PaymentDTO;
import com.ltmartinelli.gymsystem.entities.Contract;
import com.ltmartinelli.gymsystem.entities.Payment;
import com.ltmartinelli.gymsystem.repositories.ContractRepository;
import com.ltmartinelli.gymsystem.repositories.PaymentRepository;
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
    private UnitService unitService;

    @Autowired
    private PlanService planService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public ContractDTO findByUser(Long clientId) {
        Contract contract = repository.findByUser(clientId);
        authService.validateSelfOrAdmin(contract.getUser().getId());
        return new ContractDTO(contract);
    }

    @Transactional
    public ContractDTO insert(ContractDTO dto) {
        Contract contract = new Contract();
        copyDTOToContract(dto, contract);
        contract = repository.save(contract);
        return new ContractDTO(contract);
    }

    private void copyDTOToContract(ContractDTO dto, Contract entity) {
        entity.setUser(userService.findById(dto.getClientId()));
        entity.setUnit(unitService.findById(dto.getUnitId()));
        entity.setPlan(planService.findById(dto.getPlanId()));
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setInstallmentPrice(planService.findById(dto.getPlanId()).getPrice());

        for (PaymentDTO p : dto.getPayments()) {
            Payment payment = new Payment();
            payment.setStatus(p.getStatus());
            payment.setPaymentDate(p.getPaymentDate());
            payment.setPrice(p.getPrice());
            payment.setDueDate(p.getDueDate());
            payment.setContract(entity);
            payment = paymentRepository.save(payment);
            entity.getPayments().add(payment);
        }
    }
}
