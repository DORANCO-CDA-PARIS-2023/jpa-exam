package com.doranco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

import com.doranco.entity.uers.Address;

public class AddressDao implements IAddressDao {

	private final EntityManager manager;

	public AddressDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Address addAddress(Address address) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(address);
			transaction.commit();
			return address;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public Address getAddressById(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Address address = manager.find(Address.class, id);
			transaction.commit();
			return address;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public List<Address> getAddresses() throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT a FROM Address a");
			List<Address> addresses = query.getResultList();
			transaction.commit();
			return addresses;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void updateAddress(Address address) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(address);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void removeAddress(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Address address = manager.find(Address.class, id);
			manager.remove(address);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}
}
