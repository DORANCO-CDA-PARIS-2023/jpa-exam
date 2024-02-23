package com.doranco.jpaexam.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public final class Service {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "hotel_services",
            joinColumns = @JoinColumn(name = "service_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "hotel_id", nullable = false)
    )
    private List<Hotel> hotelList;

    public Service() {
        this.hotelList = new ArrayList<>();
    }
}
