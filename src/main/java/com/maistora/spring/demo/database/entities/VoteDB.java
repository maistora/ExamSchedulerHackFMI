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
@Table(name = "vote")
public class VoteDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vote", unique = true, nullable = false, precision = 11, scale = 0)
	private Long id;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_student")
	private StudentDB student;

	@Column(name = "vote_count", nullable = false, precision = 4, scale = 0)
	private Long voteCount;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_exam")
	private ExamDB exam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentDB getStudent() {
		return student;
	}

	public void setStudent(StudentDB student) {
		this.student = student;
	}

	public Long getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}

	public ExamDB getExam() {
		return exam;
	}

	public void setExam(ExamDB exam) {
		this.exam = exam;
	}

}
