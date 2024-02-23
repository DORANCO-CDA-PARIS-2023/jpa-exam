package com.doranco.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;

    private String prenom;

    private String adresse;

    private String email;

    @OneToMany (mappedBy = "client")
    private List<Reservation> reservations = new ArrayList<>();

    public Client(){}

    public Client(String nom, String prenom, String adresse, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public List<Reservation> getReservations() {return reservations;}

    @Override
    public String toString() {
        return "ClientsInformation{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
