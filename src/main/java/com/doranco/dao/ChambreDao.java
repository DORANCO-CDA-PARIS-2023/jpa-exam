package com.doranco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

import com.doranco.entity.chambres.Chambre;

public class ChambreDao implements IChambreDao {

	private final EntityManager manager;

	public ChambreDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Chambre addChambre(Chambre chambre) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(chambre);
			transaction.commit();
			return chambre;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public Chambre getChambreById(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Chambre chambre = manager.find(Chambre.class, id);
			transaction.commit();
			return chambre;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public List<Chambre> getChambres() throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT c FROM Chambre c");
			List<Chambre> chambres = query.getResultList();
			transaction.commit();
			return chambres;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void updateChambre(Chambre chambre) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(chambre);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void removeChambre(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Chambre chambre = manager.find(Chambre.class, id);
			manager.remove(chambre);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

}
