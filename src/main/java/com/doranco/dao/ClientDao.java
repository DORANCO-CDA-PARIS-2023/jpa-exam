package com.doranco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

import com.doranco.entity.uers.Client;

public class ClientDao implements IClientDao {

	private final EntityManager manager;
	
	public ClientDao(EntityManager manager) {
		this.manager = manager;
	}
	
	
	@Override
	public Client addClient(Client client) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(client);
			transaction.commit();
			return client;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public Client getClientById(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Client client = manager.find(Client.class, id);
			transaction.commit();
			return client;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public List<Client> getClients() throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT c FROM Client c");
			List<Client> clients = query.getResultList();
			transaction.commit();
			return clients;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void updateClient(Client client) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(client);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
		
	}

	@Override
	public void removeClient(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Client client = manager.find(Client.class, id);
			manager.remove(client);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
		
	}

}
