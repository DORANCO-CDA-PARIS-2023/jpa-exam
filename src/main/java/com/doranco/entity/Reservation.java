package com.doranco.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity@Table
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String dateArrivee;

    private String dateDepart;

    private String statut;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    public Reservation(){}

    public Reservation( String dateArrivée, String dateDépart, String statut, Client client, Chambre chambre) {
        this.dateArrivee = dateArrivée;
        this.dateDepart = dateDépart;
        this.statut = statut;
        this.client = client;
        this.chambre = chambre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(String dateArrivée) {
        this.dateArrivee = dateArrivée;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDépart) {
        this.dateDepart = dateDépart;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", dateArrivée=" + dateArrivee +
                ", dateDépart=" + dateDepart +
                ", statut='" + statut + '\'' +
                ", client=" + client +
                ", chambre=" + chambre +
                '}';
    }
}
