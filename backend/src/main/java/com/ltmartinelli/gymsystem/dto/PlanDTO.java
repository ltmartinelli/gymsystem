package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.Plan;

import java.util.Set;

public class PlanDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;

    public PlanDTO() {
    }

    public PlanDTO(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public PlanDTO(Plan entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
