package com.doranco.interfaces;

import com.doranco.entity.Employes;

public interface Iemployes extends Icrud<Employes> {
    public Employes findByNom(String nom);
    public Employes findByPrenom(String prenom);
    public Employes findByPoste(String poste);
    public Employes findByNomAndPrenom(String nom, String prenom);
    public Employes findByNomAndPoste(String nom, String poste);
    public Employes findByPrenomAndPoste(String prenom, String poste);
    public Employes findByNomAndPrenomAndPoste(String nom, String prenom, String poste);
}
