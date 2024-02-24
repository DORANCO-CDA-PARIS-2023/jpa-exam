package com.doranco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

import com.doranco.entity.Hotel;

public class HotelDao implements IHotelDao {

	private final EntityManager manager;
	

	public HotelDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Hotel addHotel(Hotel hotel) throws Exception {
		validateHotel(hotel);
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(hotel);
			transaction.commit();
			return hotel;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public Hotel getHotelById(Long id) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Hotel hotel = manager.find(Hotel.class, id);
			transaction.commit();
			return hotel;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public List<Hotel> getHotels() throws Exception {
	    EntityTransaction transaction = manager.getTransaction();
	    try {
	        transaction.begin();
	        Query query = manager.createQuery("SELECT h FROM Hotel h");
	        List<Hotel> hotels = query.getResultList();
	        transaction.commit();

	        if (hotels.isEmpty()) {
	            System.out.println("There are no hotels available. Please add a hotel first.");
	        }

	        return hotels;
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        throw e;
	    }
	}

	@Override
	public void updateHotel(Hotel hotel) throws Exception {
		validateHotel(hotel);
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(hotel);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
    public void removeHotel(Long id) throws Exception {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Hotel hotel = manager.find(Hotel.class, id);
            manager.remove(hotel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

	private void validateHotel(Hotel hotel) throws Exception {
        if (hotel == null) {
            throw new Exception("L'hotel est null");
        }	
        if (hotel.getName() == null || hotel.getName().isEmpty()) {
            throw new Exception("Le nom de l'hotel est null ou vide");
        }
	}

}
