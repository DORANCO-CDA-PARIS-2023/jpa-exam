package com.doranco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table
public class Employes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "poste")
    private String poste;

    public Employes() {
    }

    public Employes(String nom, String prenom, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public Employes(int id, String nom, String prenom, String poste) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public int getId() {
        return id;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override

    public String toString() {
        return "Employes{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", poste='" + poste + '\'' +
                '}';
    }
    
}
