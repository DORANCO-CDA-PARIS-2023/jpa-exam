package com.doranco.services;

import com.doranco.entity.Chambre;
import com.doranco.entity.Hotel;
import com.doranco.model.EntityManagerModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ChambreService {

	 private HotelService hotelService;

    public ChambreService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public void addRoom(int hotelId, int roomNumber, String roomType, double pricePerNight) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = EntityManagerModel.getInstance().getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            
            Hotel hotel = entityManager.find(Hotel.class, hotelId);
            if (hotel == null) {
                System.out.println("L'hôtel avec l'ID spécifié n'existe pas !");
                return;
            }
            
            Chambre chambre = new Chambre(roomNumber, roomType, pricePerNight);
            chambre.setHotel(hotel);
            
            entityManager.persist(chambre);
            
            hotel.setNombreTotalChambres(hotel.getNombreTotalChambres() + 1);
            entityManager.merge(hotel);
            
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
