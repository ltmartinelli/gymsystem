package com.ltmartinelli.gymsystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_unit_address")
public class UnitAddress extends Address {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Unit unit;

    public UnitAddress() {
    }

    public UnitAddress(Long id, String state, String city, Integer number, String zip, Unit unit) {
        super(id, state, city, number, zip);
        this.unit = unit;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "UnitAddress{" +
                "unit=" + unit +
                super.toString() +
                "} ";
    }
}
