package com.doranco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CHAMBRE")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHAMBRE")
    private Integer idChambre;

    @ManyToOne
    @JoinColumn(name = "ID_HOTEL")
    private Hotel hotel;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PRIX")
    private Double prix;

    
    public Chambre() {
		
	}
    
	public Chambre(Integer idChambre, Hotel hotel, Integer numero, String type, Double prix) {
		this.idChambre = idChambre;
		this.hotel = hotel;
		this.numero = numero;
		this.type = type;
		this.prix = prix;
	}

	public Integer getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(Integer idChambre) {
		this.idChambre = idChambre;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Chambre [idChambre=" + idChambre + ", hotel=" + hotel + ", numero=" + numero + ", type=" + type
				+ ", prix=" + prix + "]";
	}

    
}