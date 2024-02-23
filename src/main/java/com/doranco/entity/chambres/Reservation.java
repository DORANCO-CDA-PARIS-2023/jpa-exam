package com.doranco.entity.chambres;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.doranco.entity.uers.Address;
import com.doranco.entity.uers.Client;

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

	@OneToMany
	@JoinColumn(name = "id")
	private List<Chambre> chambres;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Client> clients;

	public Reservation() {
		this.chambres = new ArrayList<Chambre>();
		this.clients = new ArrayList<Client>();
	}

	public Reservation(LocalDate dateDebut, LocalDate dateFin, boolean annulee, boolean payee) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.annulee = annulee;
		this.payee = payee;
	}

	public Reservation(Long id, LocalDate dateDebut, LocalDate dateFin, boolean annulee, boolean payee) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.annulee = annulee;
		this.payee = payee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isAnnulee() {
		return annulee;
	}

	public void setAnnulee(boolean annulee) {
		this.annulee = annulee;
	}

	public boolean isPayee() {
		return payee;
	}

	public void setPayee(boolean payee) {
		this.payee = payee;
	}

	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", annulee=" + annulee
				+ ", payee=" + payee + ", chambres=" + chambres + ", clients=" + clients + "]";
	}

}
