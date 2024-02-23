package com.doranco.entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOTEL")
    private int idHotel;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "NB_CHAMBRE")
    private Integer nbChambre;

    @OneToMany(mappedBy = "hotel")
    private List<Chambre> chambres;
    
	public Integer getIdHotel() {
		return idHotel;
	}

	public Hotel(){}
	
	public Hotel(int idHotel, String nom, String adresse, Integer nbChambre, List<Chambre> chambres) {
		this.idHotel = idHotel;
		this.nom = nom;
		this.adresse = adresse;
		this.nbChambre = nbChambre;
		this.chambres = chambres;
	}
	
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	
	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
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