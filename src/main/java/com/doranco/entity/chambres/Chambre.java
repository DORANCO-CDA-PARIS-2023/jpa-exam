package com.doranco.entity.chambres;

import jakarta.persistence.*;

@Entity
@Table(name = "chambre")
public class Chambre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero")
	private String numero;

	@Column(name = "etage")
	private int etage;

	@Column(name = "disponible")
	private boolean disponible;

	@Column(name = "type")
	private String type; // (single, double, suite)

	@ManyToOne
	@JoinColumn(name = "categorie_chambre_id")
	private CategorieChambre categorieChambre;

	public Chambre() {
	}

	public Chambre(String numero, int etage, boolean disponible, CategorieChambre categorieChambre, String type) {
		this.numero = numero;
		this.etage = etage;
		this.disponible = disponible;
		this.categorieChambre = categorieChambre;
		this.type = type;
	}

	public String getNumero() {
		return numero;
	}

	public int getEtage() {
		return etage;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public CategorieChambre getCategorieChambre() {
		return categorieChambre;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public void setCategorieChambre(CategorieChambre categorieChambre) {
		this.categorieChambre = categorieChambre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Chambre{" + "numero='" + numero + '\'' + ", etage=" + etage + ", disponible=" + disponible
				+ ", categorieChambre=" + categorieChambre + '}';
	}
}
