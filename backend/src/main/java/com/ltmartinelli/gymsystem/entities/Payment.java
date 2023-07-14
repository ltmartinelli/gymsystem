package com.ltmartinelli.gymsystem.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment {

    //Payment price is defined in instantiation based on the associated contract's Plan
    //After instantiation, payment price is not supposed to be changed even if the Plan's price change in the future.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant paymentDate;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dueDate;

    private PaymentStatus status;

    private Double price;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "client_id", referencedColumnName = "client_id"),
            @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    })
    private Contract contract;


    public Payment() {
    }

    public Payment(Long id, Instant paymentDate, Instant dueDate, PaymentStatus status, Double price, Contract contract) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.dueDate = dueDate;
        this.status = status;
        this.price = price;
        this.contract = contract;
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", price=" + price +
                ", contract=" + contract +
                '}';
    }
}
