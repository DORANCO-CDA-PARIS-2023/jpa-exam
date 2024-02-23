package com.doranco.interfaces;

import com.doranco.entity.Client;

public interface Iclient extends Icrud<Client> {
public Client findByNom(String nom);

public Client findByPrenom(String prenom);

public Client findByAdresse(String adresse);

public Client findByTelephone(String telephone);
}
