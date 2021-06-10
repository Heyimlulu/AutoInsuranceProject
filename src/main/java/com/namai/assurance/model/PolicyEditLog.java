package com.namai.assurance.model;

import java.sql.Date;

import javax.persistence.CascadeType;
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

	@Column
	private String editedTableName;

	@Column
	private long policy_id_artifact;

	@Column
	private Date editedDate;

	@Column
	private String editedBy;

	@Column
	private String additionalInfos;

	@JsonBackReference(value = "editlog")
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public PolicyEditLog() {}
	
	public PolicyEditLog(long id, String editedTableName, long policy_id_artifact, Date editedDate, String editedBy, String additionalInfos, Policy policy) {
		super();
		this.id = id;
		this.editedTableName = editedTableName;
		this.policy_id_artifact = policy_id_artifact;
		this.editedDate = editedDate;
		this.editedBy = editedBy;
		this.additionalInfos = additionalInfos;
		this.policy = policy;
	}

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

	public long getPolicy_id_artifact() {
		return policy_id_artifact;
	}

	public void setPolicy_id_artifact(long policy_id_artifact) {
		this.policy_id_artifact = policy_id_artifact;
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
