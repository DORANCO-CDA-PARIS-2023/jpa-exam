package com.doranco.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public final class EntityManagerModel {

    private static EntityManagerModel instance;

    private final EntityManagerFactory entityManagerFactory;

    private EntityManagerModel() throws PersistenceException {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
    }

    public static EntityManagerModel getInstance() throws PersistenceException {
        if (instance == null) {
            instance = new EntityManagerModel();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.entityManagerFactory;
    }

    public void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
