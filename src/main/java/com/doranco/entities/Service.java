package com.doranco.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Invoice invoice;
    // Getters and setters
}