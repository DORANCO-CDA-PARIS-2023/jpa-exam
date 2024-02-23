package com.doranco.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	
	 @Column(name = "name")
	 private String name;
	 
	 @Column(name = "address")
	 private String address;
	 
	 @Column(name = "number_of_rooms")
	 private int numberOfRooms;
	 
	 @ManyToMany
	 @JoinTable(name = "hotel_service_offer", joinColumns = @JoinColumn(name = "id_hotel"), inverseJoinColumns = @JoinColumn(name = "id_service"))
	 private List<Service> services;
	 
	 @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	 private List<Employee> employees;
	 
	 @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	 private List<Room> rooms;
	 
}
