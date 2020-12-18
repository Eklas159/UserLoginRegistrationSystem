package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	@Column(nullable = false,length = 64)
	private String password;
	@Column(nullable = false, length = 18)
	private String firstName;
	@Column(nullable = false, length = 18)
	private String lastName;
	
	

}
