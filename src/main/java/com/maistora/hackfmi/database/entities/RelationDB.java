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
@Table(name = "course_teacher_group")
public class RelationDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_course_teacher_group", unique = true, nullable = false, precision = 11, scale = 0)
	private Long id;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_course", nullable = false)
	private CourseDB course;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_group", nullable = false)
	private GroupDB group;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_teacher", nullable = false)
	private TeacherDB teacher;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseDB getCourse() {
		return course;
	}

	public void setCourse(CourseDB course) {
		this.course = course;
	}

	public GroupDB getGroup() {
		return group;
	}

	public void setGroup(GroupDB group) {
		this.group = group;
	}

	public TeacherDB getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDB teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return String.format("=== Relation ===\n" +
				"ID: %d\n" +
				"Course: %s\n" +
				"Group: %s\n" +
				"Teacher: %s\n", getId(), getCourse(), getGroup(), getTeacher());
	}
}
