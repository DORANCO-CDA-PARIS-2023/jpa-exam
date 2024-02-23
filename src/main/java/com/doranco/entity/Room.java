package com.doranco.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	
	 @Column(name = "number")
	 private String number;
	 
	 @Column(name = "size")
	 private int size;
	 
	 @Column(name = "price_per_night")
	 private int pricePerNight;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_hotel")
	 private Hotel hotel;
	 
	 @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	 private List<Reservation> reservations;
	
}
