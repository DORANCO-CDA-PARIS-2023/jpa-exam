package main.java.com.doranco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Employe")
    private Long idEmployer;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Poste")
    private String poste;

    @ManyToOne
    @JoinColumn(name = "ID_Hotel", nullable = false)
    private Hotel hotel;

    // Getters et Setters

    public Long getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(Long idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
