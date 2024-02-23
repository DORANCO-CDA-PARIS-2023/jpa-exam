package com.doranco.entity.uers;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "zip_code")
	private String zipCode;

	@Column(name = "country")
	private String country;

	public Address() {
	}

	public Address(String number, String street, String city, String zipCode, String country) {
		this.number = number;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public Address(Long id, String number, String street, String city, String zipCode, String country) {
		this.id = id;
		this.number = number;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", street=" + street + ", city=" + city + ", zipCode="
				+ zipCode + ", country=" + country + "]";
	}

}
