package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.User;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

public class UserDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    private String email;
    @NotBlank(message = "Campo requerido")
    private String phone;
    @NotBlank(message = "Campo requerido")
    private LocalDate birthDate;
    @NotBlank(message = "Campo requerido")
    private ClientAddressDTO address;
    private UnitDTO unit;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, String password, String phone, LocalDate birthDate, ClientAddressDTO address, UnitDTO unit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.address = address;
        this.unit = unit;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPassword();
        birthDate = entity.getBirthDate();
        address = new ClientAddressDTO(entity.getAddress());
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ClientAddressDTO getAddress() {
        return address;
    }

    public void setAddress(ClientAddressDTO address) {
        this.address = address;
    }

    public UnitDTO getUnit() {
        return unit;
    }

    public void setUnit(UnitDTO unit) {
        this.unit = unit;
    }
}

