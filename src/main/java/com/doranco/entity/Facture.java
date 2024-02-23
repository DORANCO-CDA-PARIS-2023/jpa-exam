package com.doranco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FACTURE")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FACTURE")
    private Integer idFacture;

    @Column(name = "MONTANT")
    private Double montant;

    public Facture() {
		
	}
    
	public Facture(Integer idFacture, Double montant) {
		this.idFacture = idFacture;
		this.montant = montant;
	}

	public Integer getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Integer idFacture) {
		this.idFacture = idFacture;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", montant=" + montant + "]";
	}


	
}