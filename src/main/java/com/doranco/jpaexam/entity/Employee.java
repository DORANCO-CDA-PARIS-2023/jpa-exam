package com.doranco.jpaexam.entity;

import jakarta.persistence.*;

@Entity
@Table
@NamedQuery(name = "findAllEmployee", query = "SELECT e FROM Employee e")
@NamedQuery(name = "findEmployeeByFullName", query = "SELECT e FROM Employee e WHERE CONCAT(name, ' ', firstname) LIKE :fullname ")
public final class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String firstname;
    private String post;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel")
    private Hotel hotel;

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", post='" + post + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
