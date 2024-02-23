package com.doranco.entity;

import java.util.Date;
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
@Table(name = "reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	 @ManyToOne
	 @JoinColumn(name = "id_client")
	 private Client client;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_room")
	 private Room room;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_service")
	 private Service service;
	 
	 @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	 private List<Bill> bills;
	
}
