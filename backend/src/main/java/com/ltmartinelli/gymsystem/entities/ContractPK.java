package com.ltmartinelli.gymsystem.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContractPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    public ContractPK() {
    }

    public User getClient() {
        return client;
    }

    public void setClient(User user) {
        this.client = user;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractPK that)) return false;
        return Objects.equals(client, that.client) && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, unit);
    }

    @Override
    public String toString() {
        return "ContractPK{" +
                "client=" + client +
                ", unit=" + unit +
                '}';
    }
}
