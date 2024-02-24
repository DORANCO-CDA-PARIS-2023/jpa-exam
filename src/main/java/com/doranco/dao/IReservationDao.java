package com.doranco.dao;

import java.util.List;
import com.doranco.entity.chambres.Reservation;

public interface IReservationDao {

	Reservation addReservation(Reservation reservation) throws Exception;
	Reservation getReservationById(Long id) throws Exception;
	List<Reservation> getReservations() throws Exception;
	void updateReservation(Reservation reservation) throws Exception;
	void removeReservation(Long id) throws Exception;
	
}
