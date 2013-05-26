package com.maistora.spring.demo.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialty")
public class SpecialtyDB {

	@Column(name = "id_specialty")
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
		return String.format("=== Specialty ===\n" +
				"ID: %d\n" +
				"Name: $s\n", getId(), getName());
	}
}
