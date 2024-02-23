package com.doranco.entity.uers;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private String role;
	
	public User() {
	}
	
	public User(String username, String password, String email, String role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	public User(Long id, String username, String password, String email, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
}
