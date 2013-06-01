package com.maistora.spring.demo.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user", unique = true, nullable = false, precision = 11, scale = 0)
	private Long userId;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "fathers_name", length = 100)
	private String fathersName;
	
	@Column(name = "family_name", length = 100, nullable = false)
	private String familyName;

	@Column(name = "username", length = 255, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return String.format("=== User ===\n" +
				"User ID: %d\n" +
				"Name: %s\n" +
				"Father's name: %s\n" +
				"Family name: %s\n" +
				"Username: %s\n" +
				"Email: %s\n" +
				"Password: %s\n", 
				getUserId(), getName(), getFathersName(), getFamilyName(), getUsername(), getEmail(), getPassword());
	}
}
