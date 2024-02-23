package com.doranco.entity;

import jakarta.persistence.*;

@Entity@Table
public class ChambreInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numero;

    private String type;

    private float prix;

    private String disponibilite;

    public ChambreInformation(){}

    public ChambreInformation(int id, int numero, String type, float prix, String disponibilite) {
        this.id = id;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

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
