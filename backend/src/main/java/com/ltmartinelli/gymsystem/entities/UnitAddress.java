package com.ltmartinelli.gymsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_unit_adress")
public class UnitAddress extends Address {

    @OneToOne
    @MapsId
    private Unit unit;
}
