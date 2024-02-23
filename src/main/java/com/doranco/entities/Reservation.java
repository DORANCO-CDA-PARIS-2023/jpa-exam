package com.doranco.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;

    public Reservation(Date startDate, Date endDate, Room room, Customer customer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.customer = customer;
    }

    @ManyToOne
    private Room room;

    @ManyToOne
    private Customer customer;

    public Reservation(Long id, Date endDate, Long id1, Date startDate) {
    }

    // Getters and setters
}