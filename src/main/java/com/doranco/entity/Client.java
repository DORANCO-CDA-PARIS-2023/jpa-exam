package com.doranco.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;
    private String nom;
    private String adresse;
    private String telephone;

    public Client() {
    }

    public Client(String prenom, String nom, String adresse, String telephone) {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(prenom, client.prenom) &&
                Objects.equals(nom, client.nom) &&
                Objects.equals(adresse, client.adresse) &&
                Objects.equals(telephone, client.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenom, nom, adresse, telephone);
    }
}
