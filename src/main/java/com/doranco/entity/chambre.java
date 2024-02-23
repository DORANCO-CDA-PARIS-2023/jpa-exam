package com.doranco.entity;

public class chambre {
    private int id;
    private int numero;
    private int etage;

    public chambre() {
    }

    public chambre(int id, int numero, int etage) {
        this.id = id;
        this.numero = numero;
        this.etage = etage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    @Override
    public String toString() {
        return "chambre{" +
                "id=" + id +
                ", numero=" + numero +
                ", etage=" + etage +
                '}';
    }
}
