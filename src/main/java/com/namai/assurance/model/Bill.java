package com.namai.assurance.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private long policyIdArtifact;

	@Column
	private Date dueDate;

	@Column
	private double minimumPayment;

	@Column
	private Date createdDate;

	@Column
	private double balance;

	@Column
	private String status;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bill", cascade = { CascadeType.ALL }) // Will delete all rows mapped with the same billID
	private List<PaymentDetail> paymentDetail;

	// Payment Detail Model - GET/SET
	public List<PaymentDetail> getBill() { return paymentDetail; }
	public void setPaymentDetail(List<PaymentDetail> paymentDetail) { this.paymentDetail = paymentDetail; }
	
	public Policy getPolicy() { return policy; }
	public void setPolicy(Policy policy) { this.policy = policy; }

	public Bill() {}

	public Bill(long id, long policyIdArtifact, Date dueDate, double minimumPayment, Date createdDate, double balance, String status, Policy policy) {
		super();
		this.id = id;
		this.policyIdArtifact = policyIdArtifact;
		this.dueDate = dueDate;
		this.minimumPayment = minimumPayment;
		this.createdDate = createdDate;
		this.balance = balance;
		this.status = status;
		this.policy = policy;
	}

	public long getId() { return this.id; }
	public void setId(long id) { this.id = id; }

	public long getPolicyIdArtifact() { return policyIdArtifact; }
	public void setPolicyIdArtifact(long policyIdArtifact) { this.policyIdArtifact = policyIdArtifact; }

	public Date getDueDate() { return dueDate; }
	public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

	public double getMinimumPayment() { return minimumPayment; }
	public void setMinimumPayment(double minimumPayment) { this.minimumPayment = minimumPayment; }

	public Date getCreatedDate() { return createdDate; }
	public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

	public double getBalance() { return balance; }
	public void setBalance(double balance) { this.balance = balance; }

	public String getStatus() {	return status; }
	public void setStatus(String status) { this.status = status; }

	@Override
	public String toString() {
		return "Bill [id=" + id + ", DueDate=" + dueDate	+ ", minimumPayment=" + minimumPayment
				+ ", createdDate=" + createdDate + ", balance=" + balance + ", status=" + status + "]";
	}
}
