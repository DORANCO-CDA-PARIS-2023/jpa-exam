package com.doranco.dao;

import java.util.List;

import com.doranco.entity.Hotel;

public interface IHotelDao {

	Hotel addHotel(Hotel hotel) throws Exception;
	Hotel getHotelById(Long id) throws Exception;
	List<Hotel> getHotels() throws Exception;
	void updateHotel(Hotel hotel) throws Exception;
	void removeHotel(Long id) throws Exception;
}
