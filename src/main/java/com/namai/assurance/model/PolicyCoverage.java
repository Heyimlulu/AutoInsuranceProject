package com.namai.assurance.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "policy_coverage")
public class PolicyCoverage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private boolean active;

	@Column
	private Date createdDate;

	// Constructors

	public PolicyCoverage() {}

	public PolicyCoverage(long id, boolean active, Date createdDate) {
		super();
		this.id = id;
		this.active = active;
		this.createdDate = createdDate;
	}

	// Getters and Setters

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Vehicle Coverage " +
				"[id=" + id	+
				", active=" + active +
				", createdDate=" + createdDate +
				"]";
	}
}