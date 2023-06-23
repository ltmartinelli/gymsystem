package com.ltmartinelli.gymsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_contract")
public class Contract {

    @EmbeddedId
    private ContractPK id = new ContractPK();

    private LocalDate startDate;
    private LocalDate endDate;
    private Double installmentPrice;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    public Contract() {
    }

    public Contract(Unit unit, User user, LocalDate startDate, LocalDate endDate, Double installmentPrice, Plan plan) {
        id.setUnit(unit);
        id.setUser(user);
        this.startDate = startDate;
        this.endDate = endDate;
        this.installmentPrice = installmentPrice;
        this.plan = plan;
    }

    public Unit getUnit() {
        return id.getUnit();
    }

    public void setUnit(Unit unit) {
        id.setUnit(unit);
    }

    public User getUser() {
        return id.getUser();
    }

    public void setUser(User user) {
        id.setUser(user);
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

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract contract)) return false;
        return Objects.equals(id, contract.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", installmentPrice=" + installmentPrice +
                ", plan=" + plan +
                '}';
    }
}
