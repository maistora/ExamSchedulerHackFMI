package com.maistora.hackfmi.database.entities;

import java.util.Date;

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
@Table(name="exam")
public class ExamDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_exam", unique = true, nullable = false, precision = 11, scale = 0)
	private Long id;

	@Column(name = "start_hour")
	private Date startHour;

	@Column(name = "end_hour")
	private Date endHour;

	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rel")
	private RelationDB relation;

	@Column(name = "proposal")
	private boolean proposal;

	@Column(name = "final_exam")
	private boolean finalExam;

	@Column(name = "room_number", length = 64)
	private String roomNumber;

	@Column(name = "description", length = 64)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartHour() {
		return startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	public Date getEndHour() {
		return endHour;
	}

	public void setEndHour(Date endHour) {
		this.endHour = endHour;
	}

	public RelationDB getRelation() {
		return relation;
	}

	public void setRelation(RelationDB relation) {
		this.relation = relation;
	}

	public boolean isProposal() {
		return proposal;
	}

	public void setProposal(boolean proposal) {
		this.proposal = proposal;
	}

	public boolean isFinalExam() {
		return finalExam;
	}

	public void setFinalExam(boolean finalExam) {
		this.finalExam = finalExam;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
