package com.doranco.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	
	 @Column(name = "firstname")
	 private String firstname;
	 
	 @Column(name = "lastname")
	 private String lastname;
	 
	 @Column(name = "address")
	 private String address;
	 
	 @Column(name = "phone_number")
	 private String phoneNumber;
	 
	 @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	 private List<Reservation> reservations;
	
}
