package com.doranco.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity@Table
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numero;

    private String type;

    private double prix;

    private String disponibilite;

    @OneToMany (mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

//    @OneToOne (cascade = CascadeType.ALL)
//    private ChambreInformation information;

    public Chambre(){}

    public Chambre(int numero, String type, double prix, String disponibilite) {
        this.numero = numero;
        this.type = type;
        this.prix = prix;
        this.disponibilite = disponibilite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

//    public ChambreInformation getInformation() {return information;}

//    public void setInformation(ChambreInformation information) {this.information = information;}

    @Override
    public String toString() {
        return "ChambresInformation{" +
                "id=" + id +
                ", numero=" + numero +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                ", disponibilite='" + disponibilite + '\'' +
                '}';
    }
}
