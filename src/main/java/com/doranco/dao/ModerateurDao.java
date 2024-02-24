package com.doranco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

import com.doranco.entity.uers.Moderateur;

public class ModerateurDao implements IModerateurDao {
	
	private final EntityManager manager;
	
	public ModerateurDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Moderateur addModerateur(Moderateur moderateur) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(moderateur);
			transaction.commit();
			return moderateur;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public Moderateur getModerateurById(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Moderateur moderateur = manager.find(Moderateur.class, id);
			transaction.commit();
			return moderateur;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public List<Moderateur> getModerateurs() throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT m FROM Moderateur m");
			List<Moderateur> moderateurs = query.getResultList();
			transaction.commit();
			return moderateurs;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void updateModerateur(Moderateur moderateur) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(moderateur);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
		
	}

	@Override
	public void removeModerateur(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		
	}

}
