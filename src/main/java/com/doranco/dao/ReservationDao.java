package com.doranco.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import com.doranco.entity.chambres.Reservation;
import java.util.List;

public class ReservationDao implements IReservationDao {

	private final EntityManager manager;

	public ReservationDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Reservation addReservation(Reservation reservation) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(reservation);
			transaction.commit();
			return reservation;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public Reservation getReservationById(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Reservation reservation = manager.find(Reservation.class, id);
			transaction.commit();
			return reservation;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public List<Reservation> getReservations() throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery("SELECT r FROM Reservation r");
			List<Reservation> reservations = query.getResultList();
			transaction.commit();
			return reservations;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void updateReservation(Reservation reservation) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(reservation);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public void removeReservation(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Reservation reservation = manager.find(Reservation.class, id);
			manager.remove(reservation);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

}
