package com.doranco.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
	
	
	public Client() {}

	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
