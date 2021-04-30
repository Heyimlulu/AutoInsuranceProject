package com.namai.assurance.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="policy")
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String policyNumber;
	
	@Column
	private Date policyEffectiveDate;

	@Column
	private Date policyExpireDate;

	@Column
	private String paymentOption;

	@Column
	private double totalAmount;

	@Column
	private boolean active;

	@Column
	private String additionalInfos;

	@Column
	private Date creationDate;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "policy", cascade = { CascadeType.ALL }) // Will delete all rows mapped with the same policyID
	private List<PolicyEditLog> policyEditLogs;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "policy", cascade = { CascadeType.ALL }) // Will delete all rows mapped with the same policyID
	private List<Bill> bill;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "policy", cascade = { CascadeType.ALL }) // Will delete all rows mapped with the same policyID
	private List<PolicyCoverage> policyCoverage;
	
	// Policy Edit Log Model - GET/SET
	public List<PolicyEditLog> getPolicyEditLogs() { return policyEditLogs; }
	public void setPolicyEditLogs(List<PolicyEditLog> policyEditLogs) { this.policyEditLogs = policyEditLogs; }

	// Bill Model - GET/SET
	public List<Bill> getBill() { return bill; }
	public void setBill(List<Bill> bill) { this.bill = bill; }
	
	// PolicyCoverage Model - GET/SET
	public List<PolicyCoverage> getPolicyCoverage() { return policyCoverage; }
	public void setPolicyCoverage(List<PolicyCoverage> policyCoverage) { this.policyCoverage = policyCoverage; }
	
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

	public void setId(long id) { this.id = id; }
	
	public long getId() {
		return this.id;
	}
		
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
		return "Policy [id=" + id + ", policyNumber=" + policyNumber + ", policyEffectiveDate=" + policyEffectiveDate
				+ ", policyExpireDate=" + policyExpireDate + ", paymentOption=" + paymentOption + ", totalAmount="
				+ totalAmount + ", active=" + active + ", additionalInfos=" + additionalInfos + ", creationDate="
				+ creationDate + "]";
	}
}
