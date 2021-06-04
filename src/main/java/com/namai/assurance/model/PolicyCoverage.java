package com.namai.assurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@JsonBackReference(value = "policycoverage")
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;

	@JsonBackReference(value = "pcoverage")
	@ManyToOne
	@JoinColumn(name = "coverage_id")
	private Coverage coverage;

	public Policy getPolicy() { return policy; }
	public void setPolicy(Policy policy) { this.policy = policy; }

	public Coverage getCoverage() { return coverage; }
	public void setCoverage(Coverage coverage) { this.coverage = coverage; }


	public PolicyCoverage() {}

	public PolicyCoverage(long id, boolean active, Date createdDate, Policy policy, Coverage coverage) {
		super();
		this.id = id;
		this.active = active;
		this.createdDate = createdDate;
		this.policy = policy;
		this.coverage = coverage;
	}

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
		return "Vehicle Coverage [id=" + id	+ ", active=" + active + ", createdDate=" + createdDate + "]";
	}
}