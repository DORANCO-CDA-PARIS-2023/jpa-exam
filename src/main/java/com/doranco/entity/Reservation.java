package com.doranco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "dateDebut")
    private String dateDebut;
    @Column(name = "dateFin")
    private String dateFin;
    @Column(name = "idClient")
    private int idClient;
    @Column(name = "idChambre")
    private int idChambre;
    @Column(name = "idEmploye")
    private int idEmploye;

    public Reservation() {
    }

    public Reservation(String dateDebut, String dateFin, int idClient, int idChambre, int idEmploye) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = idClient;
        this.idChambre = idChambre;
    }

    public int getId() {
        return id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }
}