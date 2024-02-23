package com.doranco.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_reservation")
    private Long id;
    @Column(name = "date_debut")
    private Date dateDebut;
    @Column(name = "date_fin")
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "ID_chambre")
    private Chambre chambre;

    @ManyToOne
    @JoinColumn(name = "ID_client")
    private Client client;

    @ManyToMany
    @JoinTable(name = "reservation_service",
            joinColumns = @JoinColumn(name = "ID_reservation"),
            inverseJoinColumns = @JoinColumn(name = "id_service"))
    private List<Service> services = new ArrayList<>();

    public Reservation() {}
    
	public Reservation(Long id, Date dateDebut, Date dateFin) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	} 
}
