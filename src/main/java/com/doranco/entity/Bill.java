package com.doranco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	
	 @ManyToOne
	 @JoinColumn(name = "id_reservation")
	 private Reservation reservation;
	
	 @Column(name = "number_of_days")
	 private int numberOfDays;
	 
	 @Column(name = "room_price")
	 private int roomPrice;
	 
	 @Column(name = "service_price")
	 private int service_price;
	 
	 @Column(name = "total_price")
	 private int total_price;
	
}
