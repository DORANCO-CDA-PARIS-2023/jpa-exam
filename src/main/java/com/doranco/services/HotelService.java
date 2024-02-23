package com.doranco.services;

import com.doranco.entity.Hotel;
import com.doranco.model.EntityManagerModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class HotelService {

	 public void addHotel(String nom, String adresse, int nombreTotalChambres) {
	        EntityManager entityManager = null;
	        EntityTransaction transaction = null;
	        try {
	            entityManager = EntityManagerModel.getInstance().getEntityManagerFactory().createEntityManager();
	            transaction = entityManager.getTransaction();
	            transaction.begin();
	            Hotel hotel = new Hotel(nom, adresse, nombreTotalChambres);
	            entityManager.persist(hotel);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (entityManager != null) {
	                entityManager.close();
	            }
	        }
	    }
}
