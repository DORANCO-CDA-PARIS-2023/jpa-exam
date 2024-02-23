package com.doranco.jpaexam.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NamedQuery(name = "findAllBooking", query = "SELECT b FROM Booking")
public  final class Booking {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client", nullable = false)
    private Client client;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Bedroom> bedroomList;

    public Booking() {
        this.bedroomList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Bedroom> getBedroomList() {
        return bedroomList;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", client=" + client +
                ", bedroomList=" + bedroomList +
                '}';
    }
}
