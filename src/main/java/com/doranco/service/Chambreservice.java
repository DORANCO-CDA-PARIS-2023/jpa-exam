package com.doranco.service;

import com.doranco.entity.Chambres;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import com.doranco.interfaces.Ichambres;
import java.util.List;

public class Chambreservice implements Ichambres {

    private final EntityManager manager;

    public Chambreservice(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void create(Chambres chambres) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(chambres);
        transaction.commit();
    }

    @Override
    public void update(Chambres t) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(t);
        transaction.commit();
    }

    @Override
    public void delete(Chambres t) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(t);
        transaction.commit();
    }

    @Override
    public Chambres findById(int id) {
        return manager.find(Chambres.class, id);
    }

    @Override
    public Chambres[] findAll() {
        return manager
                .createQuery("SELECT l FROM Chambres l", Chambres.class)
                .getResultList()
                .toArray(new Chambres[0]);
    }

    @Override
    public Chambres findByNumero(int numero) {
        List<Chambres> chambres = manager
                .createQuery("SELECT l FROM Chambres l WHERE l.numero = :numero", Chambres.class)
                .setParameter("numero", numero)
                .getResultList();
        return chambres.isEmpty() ? null : chambres.get(0);
    }

    @Override
    public Chambres[] findByType(String type) {
        TypedQuery<Chambres> query = manager.createQuery("SELECT c FROM Chambres c WHERE c.type = :type",
                Chambres.class);
        query.setParameter("type", type);
        return query.getResultList().toArray(new Chambres[0]);
    }

    @Override
    public Chambres[] findByPrix(double prix) {
        TypedQuery<Chambres> query = manager.createQuery("SELECT c FROM Chambres c WHERE c.prix = :prix",
                Chambres.class);
        query.setParameter("prix", prix);
        return query.getResultList().toArray(new Chambres[0]);
    }

}
