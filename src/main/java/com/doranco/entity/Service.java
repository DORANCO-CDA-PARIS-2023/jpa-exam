package com.doranco.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	
	 @Column(name = "service")
	 private String service;
	 
	 @Column(name = "price")
	 private int price;
	 
	 @ManyToMany(mappedBy = "services")
	 private List<Hotel> hotels;
	 
	 @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
	 private List<Reservation> reservations;
}
