package com.doranco.jpaexam.entity;

import jakarta.persistence.*;

@Entity
@Table
@NamedQuery(name = "findAllBedroom", query = "SELECT b FROM Bedroom b")
@NamedQuery(name = "findBedroomByNumber", query = "SELECT b FROM Bedroom b WHERE b.number LIKE :number")
public final class Bedroom {

    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private String type;
    private float price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking")
    private Booking booking;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel")
    private Hotel hotel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Bedroom{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", booking=" + booking +
                ", hotel=" + hotel +
                '}';
    }
}
