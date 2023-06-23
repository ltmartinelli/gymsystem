package com.ltmartinelli.gymsystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "unit", cascade = CascadeType.ALL)
    private UnitAddress address;

}
