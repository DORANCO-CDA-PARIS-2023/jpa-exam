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
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	
	 @Column(name = "firstname")
	 private String firstname;
	 
	 @Column(name = "lastname")
	 private String lastname;
	 
	 @Column(name = "position")
	 private String position;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_hotel")
	 private Hotel hotel;
}

