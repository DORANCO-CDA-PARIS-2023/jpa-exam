package com.doranco.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String poste;
	
    @ManyToMany
    @JoinTable(
        name = "Gestion_Chambre",
        joinColumns = @JoinColumn(name = "id_emplye"),
        inverseJoinColumns = @JoinColumn(name = "id_chambre")
    )
    private List<Chambre> chambres;
	
	public Employe() {}

	public Employe(String nom, String prenom, String poste) {
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", poste=" + poste + "]";
	}

}
