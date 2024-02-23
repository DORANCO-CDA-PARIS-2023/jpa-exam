package com.doranco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  @Table
public class Chambres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "numero")
    private int numero;
    @Column(name = "type")
    private String type;
    @Column(name = "prix")
    private double prix;
    @Column(name = "disponible")
    private boolean disponible;
    

    public Chambres() {
    }

    public Chambres(int numero, String type, double prix) {
        this.numero = numero;
        this.type = type;
        this.prix = prix;
    }

    public Chambres(int id, int numero, String type, double prix, boolean disponible) {
        this.id = id;
        this.numero = numero;
        this.type = type;
        this.prix = prix;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Chambres{" +
                "id=" + id +
                ", numero=" + numero +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                ", disponible=" + disponible +
                '}';
    }
}
