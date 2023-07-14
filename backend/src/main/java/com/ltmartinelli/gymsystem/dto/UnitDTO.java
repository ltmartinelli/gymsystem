package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.Unit;

import javax.validation.constraints.NotBlank;

public class UnitDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    private UnitAddressDTO address;

    public UnitDTO() {
    }

    public UnitDTO(Long id, String name, UnitAddressDTO address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public UnitDTO(Unit entity) {
        id = entity.getId();
        name = entity.getName();
        address = new UnitAddressDTO(entity.getAddress());
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

    public UnitAddressDTO getAddress() {
        return address;
    }

    public void setAddress(UnitAddressDTO address) {
        this.address = address;
    }
}
