package com.doranco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENT")
    private Integer idClient;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "TELEPHONE")
    private String telephone;

    
    public Client() {
	}
    
	public Client(Integer idClient, String prenom, String nom, String adresse, String telephone) {
		this.idClient = idClient;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse
				+ ", telephone=" + telephone + "]";
	}

	
}