package com.doranco.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public final class EntityManager {

    private static EntityManager instance;

    private final EntityManagerFactory entityManagerFactory;

    private EntityManager() throws PersistenceException {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
    }

    public static EntityManager getInstance() throws PersistenceException {
        if (instance == null) {
            instance = new EntityManager();
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

