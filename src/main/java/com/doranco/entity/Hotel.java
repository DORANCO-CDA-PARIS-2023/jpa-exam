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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return id + ". Hôtel " + name + ", " + numberOfRooms + " chambres, " + address;
	}
	 
	 
	 
}
