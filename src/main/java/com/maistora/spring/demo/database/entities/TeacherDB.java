package com.maistora.spring.demo.database.entities;

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
@Table(name = "teacher")
public class TeacherDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_teacher", unique=true, nullable=false, precision = 11, scale = 0)
	private Long id;

	@Column(name = "title", length = 255)
	private String title;

	@Cascade(value = {CascadeType.SAVE_UPDATE, CascadeType.PERSIST})
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_user", nullable=false)
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
