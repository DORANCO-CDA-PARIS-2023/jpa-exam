package com.doranco.entity.chambres;

import com.doranco.entity.uers.Client;

import jakarta.persistence.*;

@Entity
@Table(name = "facture")
public class Facture {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "montant")
	private double montant;

	@Column(name = "payee")
	private boolean payee;

	@OneToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	@OneToOne
	@JoinColumn(name = "chambre_id")
	private Chambre chambre;

	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Facture() {
	}

	public Facture(double montant, boolean payee, Reservation reservation, Chambre chambre, Client client) {
		this.montant = montant;
		this.payee = payee;
		this.reservation = reservation;
		this.chambre = chambre;
		this.client = client;
	}
	
	public Facture(Long id, double montant, boolean payee, Reservation reservation, Chambre chambre, Client client) {
		this.id = id;
		this.montant = montant;
		this.payee = payee;
		this.reservation = reservation;
		this.chambre = chambre;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public boolean isPayee() {
		return payee;
	}

	public void setPayee(boolean payee) {
		this.payee = payee;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", montant=" + montant + ", payee=" + payee + ", reservation=" + reservation
				+ ", chambre=" + chambre + ", client=" + client + "]";
	}

}
