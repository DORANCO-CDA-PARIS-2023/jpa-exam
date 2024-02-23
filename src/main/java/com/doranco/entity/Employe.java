package com.doranco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;
    private String poste;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    
	public Employe() {}
	

	public Employe(Long id, String prenom, String nom, String poste) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.poste = poste;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
