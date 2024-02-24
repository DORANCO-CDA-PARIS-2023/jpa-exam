package com.doranco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

import com.doranco.entity.chambres.CategorieChambre;

public class CategorieChambreDao implements ICategorieChambreDao {

	private final EntityManager manager;

	public CategorieChambreDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public CategorieChambre addCategorieChambre(CategorieChambre categorieChambre) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(categorieChambre);
			transaction.commit();
			return categorieChambre;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public CategorieChambre getCategorieChambreById(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			CategorieChambre categorieChambre = manager.find(CategorieChambre.class, id);
			transaction.commit();
			return categorieChambre;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public List<CategorieChambre> getCategoriesChambre() throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT cc FROM CategorieChambre cc");
			List<CategorieChambre> categoriesChambre = query.getResultList();
			transaction.commit();
			return categoriesChambre;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void updateCategorieChambre(CategorieChambre categorieChambre) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(categorieChambre);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void removeCategorieChambre(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			CategorieChambre categorieChambre = manager.find(CategorieChambre.class, id);
			manager.remove(categorieChambre);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}

	}

}
