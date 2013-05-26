package com.maistora.spring.demo.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_course")
	private Long id;

	@Column(name = "name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
		return String.format("=== Course ===\n" +
				"ID: %d\n" +
				"Name: %s\n", getId(), getName());
	}
}
