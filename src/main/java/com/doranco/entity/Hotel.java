package com.doranco.entity;

import java.util.HashSet;
import java.util.Set;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity	
@Table(name ="hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hotel")	
		private int id_hotel;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id_address")
    private Address address;
	
	@Column(name="vacant_room")
	private int vacant_room;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "hotel_service", 
        joinColumns = @JoinColumn(name = "hotel_id"), 
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service_proposed> services = new HashSet<>();
	
	@OneToMany(mappedBy = "hotel")
    private Set<Room> rooms = new HashSet<>();

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Hotel(String name, int vacant_room) {
		super();
		this.name = name;
		this.vacant_room = vacant_room;

	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getVacant_room() {
		return vacant_room;
	}

	public void setVacant_room(int vacant_room) {
		this.vacant_room = vacant_room;
	}

	public Set<Service_proposed> getServices() {
		return services;
	}

	public void setServices(Set<Service_proposed> services) {
		this.services = services;
	}

	public int getId_hotel() {
		return id_hotel;
	}

	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", name=" + name + ", address=" + address + ", vacant_room="
				+ vacant_room + ", services=" + services + ", rooms=" + rooms + "]";
	}

	
}
