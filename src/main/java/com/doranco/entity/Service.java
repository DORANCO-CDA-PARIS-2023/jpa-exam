package com.doranco.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @ManyToMany(mappedBy = "services")
    private List<Reservation> reservations = new ArrayList<>();

    public Service() {}
    
	public Service(Long id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
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

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}     
}
