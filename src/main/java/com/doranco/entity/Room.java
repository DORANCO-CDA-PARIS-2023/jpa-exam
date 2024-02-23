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
@Table(name ="hotel")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_room")	
		private int id_room;
	
	@Column(name="number")
	private String number;
	
	@ManyToOne
    @JoinColumn(name="id_type")
    private Type type;
	
	@Column(name="price")
	private float price;
	
	@ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel hotel;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String number, Type type, float price, Hotel hotel) {
		super();
		this.number = number;
		this.type = type;
		this.price = price;
		this.hotel = hotel;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getId_room() {
		return id_room;
	}

	@Override
	public String toString() {
		return "Room [id_room=" + id_room + ", number=" + number + ", type=" + type + ", price=" + price + ", hotel="
				+ hotel + "]";
	}
	
	


}
