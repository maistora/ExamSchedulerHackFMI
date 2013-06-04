package com.maistora.hackfmi.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "group")
public class GroupDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_group", unique = true, nullable = false, precision = 11, scale = 0)
	private Long id;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_specialty", nullable = false)
	private SpecialtyDB specialty;

	@Column(name = "year", length = 4, nullable = false, precision = 4, scale = 0)
	private Long year;

	// TODO see if number should be string value to cover values like a, b, c .. etc.
	@Column(name = "number", length = 4, nullable = false, precision = 4, scale = 0)
	private Long number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SpecialtyDB getSpecialty() {
		return specialty;
	}

	public void setSpecialty(SpecialtyDB specialty) {
		this.specialty = specialty;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("=== Group ===\n" +
				"ID: %d\n" +
				"Specialty: %s\n" +
				"Year: %d\n" +
				"Number: %d\n", getId(), getSpecialty(), getYear(), getNumber());
	}
}
