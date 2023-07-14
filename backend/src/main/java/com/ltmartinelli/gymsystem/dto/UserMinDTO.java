package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.User;

public class UserMinDTO {

    //User DTO with minimal information, used by listing page when searching users by name.

    private Long id;
    private String name;
    private String email;
    private String unitName;

    public UserMinDTO() {
    }

    public UserMinDTO(Long id, String name, String email, String unitName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.unitName = unitName;
    }

    public UserMinDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        unitName = entity.getUnit().getName();
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}

