package com.ltmartinelli.gymsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_address")
public class UserAddress extends Address {

    @OneToOne
    @MapsId
    private User user;

    public UserAddress() {
    }

    public UserAddress(Long id, String state, String city, Integer number, String zip, User user) {
        super(id, state, city, number, zip);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "user=" + user +
                super.toString() +
                "} ";
    }
}
