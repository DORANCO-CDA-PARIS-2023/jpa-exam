package com.doranco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Chambre")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String type;
    private double prixParNuit;

    @ManyToOne
    @JoinColumn(name = "id")
    private Hotel hotel;

    public Chambre() {
    }

    public Chambre(String numero, String type, double prixParNuit, Hotel hotel) {
        this.numero = numero;
        this.type = type;
        this.prixParNuit = prixParNuit;
        this.hotel = hotel;
    }
}
