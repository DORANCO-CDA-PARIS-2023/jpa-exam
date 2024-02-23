package com.doranco.entity.uers;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@Column(name="country")
	private String country;
	
	
}
