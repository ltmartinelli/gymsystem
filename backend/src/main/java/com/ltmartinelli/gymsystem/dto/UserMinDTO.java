package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.User;

public class UserMinDTO {

    private Long id;
    private String name;
    private String email;
    private UnitDTO unit;

    public UserMinDTO() {
    }

    public UserMinDTO(Long id, String name, String email, UnitDTO unit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.unit = unit;
    }

    public UserMinDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        unit = new UnitDTO(entity.getUnit());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UnitDTO getUnit() {
        return unit;
    }

    public void setUnit(UnitDTO unit) {
        this.unit = unit;
    }
}

