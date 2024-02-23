package com.doranco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOTEL")
    private Integer idHotel;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "NB_CAMBRE")
    private Integer nbChambre;

	public Integer getIdHotel() {
		return idHotel;
	}

	public Hotel(){}
	

	public Hotel(Integer idHotel, String nom, String adresse, Integer nbChambre) {
		this.idHotel = idHotel;
		this.nom = nom;
		this.adresse = adresse;
		this.nbChambre = nbChambre;
	}



	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getNbChambre() {
		return nbChambre;
	}

	public void setNbChambre(Integer nbChambre) {
		this.nbChambre = nbChambre;
	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nom=" + nom + ", adresse=" + adresse + ", nbChambre=" + nbChambre + "]";
	}
	
	
    
}