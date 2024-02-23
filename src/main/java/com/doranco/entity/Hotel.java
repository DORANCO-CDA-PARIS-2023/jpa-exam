package com.doranco.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private int nombreTotalChambres;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Chambre> chambres = new ArrayList<>();

    public Hotel() {}
    
	public Hotel(String nom, String adresse, int nombreTotalChambres) {
		this.nom = nom;
		this.adresse = adresse;
		this.nombreTotalChambres = nombreTotalChambres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getNombreTotalChambres() {
		return nombreTotalChambres;
	}

	public void setNombreTotalChambres(int nombreTotalChambres) {
		this.nombreTotalChambres = nombreTotalChambres;
	}

	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}    
}
