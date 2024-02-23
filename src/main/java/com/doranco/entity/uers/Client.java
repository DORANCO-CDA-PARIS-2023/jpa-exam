package com.doranco.entity.uers;

import jakarta.persistence.*;

@Entity
@Table(name="client")
public class Client extends Persson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Client() {}
	
	public Client(User user) {
		super();
		this.user = user;
	}
	
	
	
}
