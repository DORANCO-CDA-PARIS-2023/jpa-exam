package com.doranco.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Chambre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String type;
	private double prix;
	private boolean disponibilite;
	

    @OneToMany(mappedBy = "chambre")
    private List<Reservation> reservations;
	
	public Chambre() {}

	public Chambre(String numero, String type, double prix, boolean disponibilite) {
		this.numero = numero;
		this.type = type;
		this.prix = prix;
		this.disponibilite = disponibilite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Override
	public String toString() {
		return "Chambre [id=" + id + ", numero=" + numero + ", type=" + type + ", prix=" + prix + ", disponibilite="
				+ disponibilite + "]";
	}

}
