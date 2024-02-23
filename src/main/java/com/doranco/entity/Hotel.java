package com.doranco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private int nbChambresDisponibles;

    public Hotel() {
    }

    public Hotel(String nom, String adresse, int nbChambresDisponibles) {
        this.nom = nom;
        this.adresse = adresse;
        this.nbChambresDisponibles = nbChambresDisponibles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbChambresDisponibles() {
        return nbChambresDisponibles;
    }

    public void setNbChambresDisponibles(int nbChambresDisponibles) {
        this.nbChambresDisponibles = nbChambresDisponibles;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nbChambresDisponibles=" + nbChambresDisponibles +
                '}';
    }
}
