package com.doranco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity	
@Table(name ="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_address")	
		private int id_address;
	
	@Column(name="town")
	private String town;
	
	@Column(name="number")
	private String number;
	
	@Column(name="street")
	private String street;
	
	@Column(name="postal_code")
	private String postal_code;
	
	@Column(name="country")
	private String country;
	
}
