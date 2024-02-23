package com.doranco.entity;

public class Hotel {

    private int id;
    private String nom;
    private String adresse;
    private int numeroHotel;

    public Hotel() {
    }

    public Hotel(int id, String nom, String adresse, int numeroHotel) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numeroHotel = numeroHotel;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumeroHotel() {
        return numeroHotel;
    }

    public void setNumeroHotel(int numeroHotel) {
        this.numeroHotel = numeroHotel;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numeroHotel=" + numeroHotel +
                '}';
    }
}
