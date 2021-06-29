package com.project.insurance.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "policy_edit_log")
public class PolicyEditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String editedTableName;

	@Column(nullable = false)
	private Date editedDate;

	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String editedBy;

	@Column(columnDefinition = "text")
	private String additionalInfos;

	// Relations

	@JsonBackReference(value = "editlog")
	@ManyToOne
	@JoinColumn(name = "policy_id", nullable = false)
	private Policy policy;

	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	// Constructors

	public PolicyEditLog() {}
	
	public PolicyEditLog(long id, String editedTableName, Date editedDate, String editedBy, String additionalInfos, Policy policy) {
		super();
		this.id = id;
		this.editedTableName = editedTableName;
		this.editedDate = editedDate;
		this.editedBy = editedBy;
		this.additionalInfos = additionalInfos;
		this.policy = policy;
	}

	// Getters and Setters

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getEditedTableName() {
		return editedTableName;
	}
	public void setEditedTableName(String editedTableName) {
		this.editedTableName = editedTableName;
	}

	public Date getEditedDate() {
		return editedDate;
	}
	public void setEditedDate(Date editedDate) {
		this.editedDate = editedDate;
	}

	public String getEditedBy() {
		return editedBy;
	}
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public String getAdditionalInfos() {
		return additionalInfos;
	}
	public void setAdditionalInfos(String additionalInfos) {
		this.additionalInfos = additionalInfos;
	}

	@Override
	public String toString() {
		return "PolicyEditLog " +
				"[id=" + id +
				", editedTableName=" + editedTableName +
				", editedDate=" + editedDate +
				", editedBy=" + editedBy +
				", additionalInfos=" + additionalInfos +
				"]";
	}
}
