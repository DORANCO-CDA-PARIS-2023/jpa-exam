package com.doranco.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateDebutReservation;
	private Date dateFinReservation;

    @ManyToOne
    @JoinColumn(name = "id_chambre")
    private Chambre chambre;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    
    @ManyToMany
    @JoinTable(
        name = "Reservation_Service",
        joinColumns = @JoinColumn(name = "id_reservation"),
        inverseJoinColumns = @JoinColumn(name = "id_service")
    )
    private List<Service> services;
    
	public Reservation() {}

	public Reservation(Date dateDebutReservation, Date dateFinReservation, Chambre chambre, Client client) {
		this.dateDebutReservation = dateDebutReservation;
		this.dateFinReservation = dateFinReservation;
		this.chambre = chambre;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDebutReservation() {
		return dateDebutReservation;
	}

	public void setDateDebutReservation(Date dateDebutReservation) {
		this.dateDebutReservation = dateDebutReservation;
	}

	public Date getDateFinReservation() {
		return dateFinReservation;
	}

	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
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
	
	
	
    

}
