package com.doranco.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYE")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPLOYE")
    private Integer idEmploye;

    @ManyToOne
    @JoinColumn(name = "ID_HOTEL")
    private Hotel hotel;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "POSTE")
    private String poste;

    public Employe() {
		
	}
    
	public Employe(Integer idEmploye, Hotel hotel, String nom, String prenom, String poste) {
		this.idEmploye = idEmploye;
		this.hotel = hotel;
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
	}

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", hotel=" + hotel + ", nom=" + nom + ", prenom=" + prenom
				+ ", poste=" + poste + "]";
	}


}