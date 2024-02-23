package com.doranco.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Chambre")
    private Long id;
    
    @Column(name = "numeroChambre")
    private int numero;
    @Column(name = "type")
    private String type;
    @Column(name = "prix")
    private double prixParNuit;

    @ManyToOne
    @JoinColumn(name = "ID_Hotel")
    private Hotel hotel;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Chambre() {}
    
	public Chambre(int numero, String type, double prixParNuit) {
		this.numero = numero;
		this.type = type;
		this.prixParNuit = prixParNuit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrixParNuit() {
		return prixParNuit;
	}

	public void setPrixParNuit(double prixParNuit) {
		this.prixParNuit = prixParNuit;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
