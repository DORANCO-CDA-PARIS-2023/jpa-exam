package com.doranco.entity.uers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="persson")
public class Persson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
    @OneToMany (mappedBy = "id")
    private List<Address> addresses = new ArrayList<>();
	
}
