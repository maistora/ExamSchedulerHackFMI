package com.maistora.spring.demo.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class TeacherDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_teacher")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "user_fk")
	private UserDB user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UserDB getUser() {
		return user;
	}

	public void setUser(UserDB user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format("=== Course ===\n" + 
				"ID: %d\n" + 
				"Name: %s\n" +
				"Title: %s\n",
				getId(), getUser().getName(), getTitle());
	}
}
