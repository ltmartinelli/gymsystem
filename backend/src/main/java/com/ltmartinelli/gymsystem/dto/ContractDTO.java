package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.Contract;
import com.ltmartinelli.gymsystem.entities.Payment;

import javax.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ContractDTO {

    private Long clientId;
    private Long unitId;
    @PastOrPresent(message = "A data não pode ser no futuro")
    private LocalDate startDate;
    @Future(message = "A data não pode ser no passado")
    private LocalDate endDate;
    @Positive
    private Double installmentPrice;
    @NotBlank(message = "Campo requerido")
    private String planName;

    private Set<PaymentDTO> payments = new HashSet<>();

    public ContractDTO() {
    }

    public ContractDTO(Long clientId, Long unitId, LocalDate startDate, LocalDate endDate, Double installmentPrice, String planName) {
        this.clientId = clientId;
        this.unitId = unitId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.installmentPrice = installmentPrice;
        this.planName = planName;
    }

    public ContractDTO(Contract entity) {
        clientId = entity.getUser().getId();
        unitId = entity.getUnit().getId();
        startDate = entity.getStartDate();
        endDate = entity.getEndDate();
        installmentPrice = entity.getInstallmentPrice();
        planName = entity.getPlan().getName();

        for(Payment p : entity.getPayments()){
            payments.add(new PaymentDTO(p));
        }
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getInstallmentPrice() {
        return installmentPrice;
    }

    public void setInstallmentPrice(Double installmentPrice) {
        this.installmentPrice = installmentPrice;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Set<PaymentDTO> getPayments() {
        return payments;
    }
}
