package com.doranco.entity.uers;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="moderateur")
public class Moderateur extends Persson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Moderateur() {}

	public Moderateur(User user) {
		super();
		this.user = user;
	}
	
	
}
