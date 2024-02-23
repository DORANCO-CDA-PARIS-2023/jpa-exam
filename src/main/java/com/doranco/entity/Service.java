package com.doranco.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	private double prix;
	
    @ManyToMany(mappedBy = "services")
    private List<Reservation> reservations;
	
	public Service() {}

	public Service(String nom, String description, double prix) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + "]";
	}
	
	

}
