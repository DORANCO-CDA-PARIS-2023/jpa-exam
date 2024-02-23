package com.doranco.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity	
@Table(name ="service")
public class Service_proposed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_service")	
		private int id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="included")
		private Boolean included = false;
		
		@Column(name="price")
		private float price;
		
		  @ManyToMany(mappedBy = "services")
		    private Set<Hotel> hotels = new HashSet<>();

		public Service_proposed() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Set<Hotel> getHotels() {
			return hotels;
		}

		public void setHotels(Set<Hotel> hotels) {
			this.hotels = hotels;
		}

		public Service_proposed(String name, Boolean included, float price) {
			super();
			this.name = name;
			this.included = included;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Boolean getIncluded() {
			return included;
		}

		public void setIncluded(Boolean included) {
			this.included = included;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return "Service [id=" + id + ", name=" + name + ", included=" + included + ", price=" + price + ", hotels="
					+ hotels + "]";
		}

		
		
		
}
