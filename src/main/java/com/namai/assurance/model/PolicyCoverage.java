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
	private long policyId;

	@Column
	private long coverageId;

	@Column
	private boolean active;

	@Column
	private Date createdDate;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "coverage_id")
	private Coverage coverage;

	public Policy getPolicy() { return policy; }
	public void setPolicy(Policy policy) { this.policy = policy; }

	public Coverage getCoverage() { return coverage; }
	public void setCoverage(Coverage coverage) { this.coverage = coverage; }

	public PolicyCoverage() {}

	public PolicyCoverage(long id, long policyId, long coverageId, boolean active, Date createdDate, Policy policy, Coverage coverage) {
		super();
		this.id = id;
		this.policyId = policyId;
		this.coverageId = coverageId;
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

	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public long getCoverageId() {
		return coverageId;
	}
	public void setCoverageId(long coverageId) {
		this.coverageId = coverageId;
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
		return "Vehicle Coverage [id=" + id + ", policyId=" + policyId + ", coverageId=" + coverageId
				+ ", active=" + active + ", createdDate=" + createdDate + "]";
	}
}
