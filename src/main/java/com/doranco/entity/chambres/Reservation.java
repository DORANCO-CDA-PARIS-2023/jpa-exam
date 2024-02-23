package com.doranco.entity.chambres;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "date_debut")
	private LocalDate dateDebut;

	@Column(name = "date_fin")
	private LocalDate dateFin;

	@Column(name = "annulee")
	private boolean annulee;

	@Column(name = "payee")
	private boolean payee;

	@ManyToOne
	private Chambre chambre;

	public Reservation() {
	}

	public Reservation(LocalDate dateDebut, LocalDate dateFin, boolean annulee, boolean payee, Chambre chambre) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.annulee = annulee;
		this.payee = payee;
		this.chambre = chambre;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public boolean isAnnulee() {
		return annulee;
	}

	public boolean isPayee() {
		return payee;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public void setAnnulee(boolean annulee) {
		this.annulee = annulee;
	}

	public void setPayee(boolean payee) {
		this.payee = payee;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	@Override
	public String toString() {
		return "Reservation{" + "dateDebut='" + dateDebut + '\'' + ", dateFin='" + dateFin + '\'' + ", annulee="
				+ annulee + ", payee=" + payee + ", chambre=" + chambre + '}';
	}
}
