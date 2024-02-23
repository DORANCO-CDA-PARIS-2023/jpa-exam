package com.doranco.entity.uers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "id")
	private List<Address> addresses;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Client() {
		this.addresses = new ArrayList<Address>();
	}

	public Client(String firstName, String lastName, String telephone, String gender, LocalDate dateOfBirth,
			User user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.user = user;
		this.addresses = new ArrayList<Address>();
	}

	public Client(Long id, String firstName, String lastName, String telephone, String gender, LocalDate dateOfBirth,
			User user) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.user = user;
		this.addresses = new ArrayList<Address>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", telephone=" + telephone
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", addresses=" + addresses + ", user=" + user
				+ "]";
	}

}
