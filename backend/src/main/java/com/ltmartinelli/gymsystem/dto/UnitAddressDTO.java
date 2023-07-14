package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.UnitAddress;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class UnitAddressDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String state;
    @NotBlank(message = "Campo requerido")
    private String city;
    @NotBlank(message = "Campo requerido")
    private String street;
    @NotBlank(message = "Campo requerido")
    @Positive(message = "O número deve ser positivo")
    private Integer number;
    @NotBlank(message = "Campo requerido")
    private String zip;
    private Long unitId;

    public UnitAddressDTO() {
    }

    public UnitAddressDTO(Long id, String state, String city, String street, Integer number, String zip, Long unitId) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.unitId = unitId;
    }

    public UnitAddressDTO(UnitAddress entity) {
        id = entity.getId();
        state = entity.getState();
        city = entity.getCity();
        street = entity.getStreet();
        number = entity.getNumber();
        zip = entity.getZip();
        unitId = entity.getUnit().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
}
