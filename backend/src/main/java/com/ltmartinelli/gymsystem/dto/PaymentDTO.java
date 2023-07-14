package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.Payment;
import com.ltmartinelli.gymsystem.entities.PaymentStatus;

import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import java.time.Instant;

public class PaymentDTO {

    private Long id;
    private Instant paymentDate;
    @Future(message = "A data não pode ser no passado")
    private Instant dueDate;
    private PaymentStatus status;
    @Positive(message = "O valor deve ser positivo")
    private Double price;
    private Long userId;

    public PaymentDTO() {
    }

    public PaymentDTO(Long id, Instant paymentDate, Instant dueDate, PaymentStatus status, Double price, Long contractId, Long userId) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.dueDate = dueDate;
        this.status = status;
        this.price = price;
        this.userId = userId;
    }

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        paymentDate = entity.getPaymentDate();
        dueDate = entity.getDueDate();
        status = entity.getStatus();
        price = entity.getPrice();
        userId = entity.getContract().getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
