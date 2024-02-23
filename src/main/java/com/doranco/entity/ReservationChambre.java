package com.doranco.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESERVATIONCHAMBRE")
@IdClass(ReservationChambreId.class)
public class ReservationChambre {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_HOTEL")
    private Hotel hotel;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_FACTURE")
    private Facture facture;

    @Column(name = "DATEDEBUT")
    private Date dateDebut;

    @Column(name = "DATEFIN")
    private Date dateFin;

    public ReservationChambre() {
	}
    
	public ReservationChambre(Hotel hotel, Client client, Facture facture, Date dateDebut, Date dateFin) {
		this.hotel = hotel;
		this.client = client;
		this.facture = facture;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "ReservationChambre [hotel=" + hotel + ", client=" + client + ", facture=" + facture + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + "]";
	}

   
}