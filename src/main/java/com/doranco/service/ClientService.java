package com.doranco.service;

import com.doranco.interfaces.Iclient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import com.doranco.entity.Client;

public class ClientService implements Iclient {
    private final EntityManager manager;

    public ClientService(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Client client) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(client);
        transaction.commit();
    }

    public void update(Client client) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(client);
        transaction.commit();

    }

    public void delete(Client client) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(client);
        transaction.commit();
    }

    @Override
    public Client findById(int id) {
        return manager.find(Client.class, id);
    }

    @Override
    public Client[] findAll() {
        return manager
                .createQuery("SELECT l FROM Client l", Client.class)
                .getResultList()
                .toArray(new Client[0]);
    }

    @Override
    public Client findByNom(String nom) {
        TypedQuery<Client> query = manager.createQuery("SELECT l FROM Client l WHERE l.nom = :nom", Client.class);
        query.setParameter("nom", nom);
        return query.getSingleResult();
    }

    @Override
    public Client findByPrenom(String prenom) {
        TypedQuery<Client> query = manager.createQuery("SELECT l FROM Client l WHERE l.prenom = :prenom", Client.class);
        query.setParameter("prenom", prenom);
        return query.getSingleResult();

    }

    @Override
    public Client findByAdresse(String adresse) {
        TypedQuery<Client> query = manager.createQuery("SELECT l FROM Client l WHERE l.adresse = :adresse",
                Client.class);
        query.setParameter("adresse", adresse);
        return query.getSingleResult();
    }

    @Override
    public Client findByTelephone(String telephone) {
        TypedQuery<Client> query = manager.createQuery("SELECT l FROM Client l WHERE l.telephone = :telephone",
                Client.class);
        query.setParameter("telephone", telephone);
        return query.getSingleResult();
    }

}
