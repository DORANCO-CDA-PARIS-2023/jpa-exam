package com.doranco.jpaexam.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NamedQuery(name = "findAll", query = "SELECT h FROM Hotel h")
@NamedQuery(name = "findByName", query = "SELECT h FROM Hotel h WHERE name LIKE :name")
public final class Hotel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "hotel",  cascade = CascadeType.ALL)
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Bedroom> bedroomList;
    @ManyToMany(mappedBy = "hotelList", cascade = CascadeType.ALL)
    private List<Service> serviceList;

    public Hotel() {
        this.employeeList = new ArrayList<>();
        this.bedroomList = new ArrayList<>();
        this.serviceList = new ArrayList<>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Bedroom> getBedroomList() {
        return bedroomList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
