package com.doranco.jpaexam.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public final class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String firstname;
    private String address;
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Booking> bookingList;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
