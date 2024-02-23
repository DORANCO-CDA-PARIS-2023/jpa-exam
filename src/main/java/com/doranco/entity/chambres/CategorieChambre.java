package com.doranco.entity.chambres;

import jakarta.persistence.*;

@Entity
@Table(name = "categorie_chambre")
public class CategorieChambre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "prix")
	private double prix;

	public CategorieChambre() {}

	public CategorieChambre(String nom, String description, double prix) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}

	public double getPrix() {
		return prix;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "CategorieChambre{" + "nom='" + nom + '\'' + ", description='" + description + '\'' + ", prix=" + prix
				+ '}';
	}
}
