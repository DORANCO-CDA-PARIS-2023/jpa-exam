package com.doranco.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAmount;

    @OneToMany(mappedBy = "invoice")
    private List<Service> services;

    @ManyToOne
    private Reservation reservation;

    // Getters and setters
}