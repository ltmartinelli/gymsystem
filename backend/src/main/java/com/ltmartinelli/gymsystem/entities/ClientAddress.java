package com.ltmartinelli.gymsystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_client_address")
public class ClientAddress extends Address {

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private User client;

    public ClientAddress() {
    }

    public ClientAddress(Long id, String state, String city, Integer number, String zip, User user) {
        super(id, state, city, number, zip);
        this.client = user;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientAddress{" +
                "client=" + client +
                super.toString() +
                "} ";
    }
}
