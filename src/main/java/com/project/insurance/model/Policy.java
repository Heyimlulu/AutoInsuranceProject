package com.project.insurance.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="policy")
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, columnDefinition = "nvarchar(20)")
	private String policyNumber;
	
	@Column(nullable = false)
	private Date policyEffectiveDate;

	@Column(nullable = false)
	private Date policyExpireDate;

	@Column(nullable = false, columnDefinition = "varchar(100)")
	private String paymentOption;

	@Column(nullable = false)
	private double totalAmount;

	@Column(nullable = false)
	private boolean active;

	@Column(columnDefinition = "text")
	private String additionalInfos;

	@Column(nullable = false)
	private Date creationDate;
	
	/*
	 * ======== Relations ========
	 * 
	 * ==== It will delete all rows mapped with the same policyID ====
	 */

	@JsonManagedReference(value = "editlog")
	@OneToMany(mappedBy = "policy", cascade = { CascadeType.ALL })
	private List<PolicyEditLog> policyEditLogs = new ArrayList<>();

	@JsonManagedReference(value = "bill")
	@OneToMany(mappedBy = "policy", cascade = { CascadeType.ALL })
	private List<Bill> bill = new ArrayList<>();

	@JsonManagedReference(value = "driver")
	@OneToMany(mappedBy = "policy", cascade = { CascadeType.ALL })
	private List<Driver> driver = new ArrayList<>();

	@JsonManagedReference(value = "vehicle")
	@OneToMany(mappedBy = "policy", cascade = { CascadeType.ALL })
	private List<Vehicle> vehicle = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "policy_coverage",
			joinColumns = {
				@JoinColumn(name = "policy_id", referencedColumnName = "id", nullable = false, updatable = false
			)},
			inverseJoinColumns = {
				@JoinColumn(name = "coverage_id", referencedColumnName = "id", nullable = false, updatable = false
			)})
	private List<Coverage> coverage= new ArrayList<>();

	// Constructors

	public Policy()
	{}

	public Policy(long id, String policyNumber, Date policyEffectiveDate, Date policyExpireDate, String paymentOption, double totalAmount, boolean active, String additionalInfos, Date creationDate) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.policyEffectiveDate = policyEffectiveDate;
		this.policyExpireDate = policyExpireDate;
		this.paymentOption = paymentOption;
		this.totalAmount = totalAmount;
		this.active = active;
		this.additionalInfos = additionalInfos;
		this.creationDate = creationDate;
	}

	// Getters and Setters

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
		
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Date getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}
	public void setPolicyEffectiveDate(Date policyEffectiveDate) {
		this.policyEffectiveDate = policyEffectiveDate;
	}

	public Date getPolicyExpireDate() {
		return policyExpireDate;
	}
	public void setPolicyExpireDate(Date policyExpireDate) {
		this.policyExpireDate = policyExpireDate;
	}
	
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAdditionalInfos() {
		return additionalInfos;
	}
	public void setAdditionalInfos(String additionalInfos) {
		this.additionalInfos = additionalInfos;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Policy " +
				"[id=" + id +
				", policyNumber=" + policyNumber +
				", policyEffectiveDate=" + policyEffectiveDate +
				", policyExpireDate=" + policyExpireDate +
				", paymentOption=" + paymentOption +
				", totalAmount=" + totalAmount +
				", active=" + active +
				", additionalInfos=" + additionalInfos +
				", creationDate=" + creationDate +
				"]";
	}
}
