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
@Table(name = "student")
public class StudentDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_student", unique = true, nullable = false, precision = 11, scale = 0)
	private Long id;

	@Column(name = "faculty_number", length = 8, unique = true, nullable = false)
	private String facultyNumber;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private UserDB user;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_group")
	private GroupDB group;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public UserDB getUser() {
		return user;
	}

	public void setUser(UserDB user) {
		this.user = user;
	}

	public GroupDB getGroup() {
		return group;
	}

	public void setGroup(GroupDB group) {
		this.group = group;
	}

}
