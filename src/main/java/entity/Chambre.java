package entity;

import jakarta.persistence.*;

@Entity
@Table
public final class Chambre {

    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private String type;
    private float price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "getReservation")
    private Reservation getReservation;
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

    public Reservation getgetReservation() {
        return getReservation;
    }

    public void setgetReservation(Reservation getReservation) {
        this.getReservation = getReservation;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}