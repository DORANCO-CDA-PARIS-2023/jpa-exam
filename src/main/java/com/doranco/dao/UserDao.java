package com.doranco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Set;

import com.doranco.entity.uers.User;

public class UserDao implements IUserDao {

	private final EntityManager manager;

	public UserDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public User addUser(User user) throws Exception {
		validateUser(user);
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return user;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public User getUserById(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			User user = manager.find(User.class, id);
			transaction.commit();
			return user;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT u FROM User u WHERE u.email = :email");
			query.setParameter("email", email);
			User user = (User) query.getSingleResult();
			transaction.commit();
			return user;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public List<User> getUsers() throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT u FROM User u");
			List<User> users = query.getResultList();
			transaction.commit();
			return users;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void updateUser(User user) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}

	}

	@Override
	public void removeUser(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			User user = manager.find(User.class, id);
			manager.remove(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}

	}

	@Override
	public Set<String> getEmails() throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT u.email FROM User u");
			Set<String> emails = (Set<String>) query.getResultList();
			transaction.commit();
			return emails;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	private void validateUser(User user) {
		if (user == null || user.getUsername() == null || user.getUsername().trim().isEmpty()) {
			throw new IllegalArgumentException("User cannot be null, and userName is required.");
		}
	}

}
