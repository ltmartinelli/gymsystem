package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.ClientAddress;
import com.ltmartinelli.gymsystem.entities.UnitAddress;

public class ClientAddressDTO {

    private Long id;
    private String state;
    private String city;
    private String street;
    private Integer number;
    private String zip;
    private Long clientId;

    public ClientAddressDTO() {
    }

    public ClientAddressDTO(Long id, String state, String city, String street, Integer number, String zip, Long clientId) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.clientId = clientId;
    }

    public ClientAddressDTO(ClientAddress entity) {
        id = entity.getId();
        state = entity.getState();
        city = entity.getCity();;
        street = entity.getStreet();
        number = entity.getNumber();
        zip = entity.getZip();
        clientId = entity.getClient().getId();
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
        this.clientId = clientId;
    }
}
