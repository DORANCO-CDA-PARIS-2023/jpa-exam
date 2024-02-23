package com.doranco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SERVICE")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICE")
    private Integer idService;

    @ManyToOne
    @JoinColumn(name = "ID_HOTEL")
    private Hotel hotel;

    @Column(name = "NOM")
    private String nom;

    public Service() {
		
	}
    
	public Service(Integer idService, Hotel hotel, String nom) {
		this.idService = idService;
		this.hotel = hotel;
		this.nom = nom;
	}

	public Integer getIdService() {
		return idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Service [idService=" + idService + ", hotel=" + hotel + ", nom=" + nom + "]";
	}

    
}
