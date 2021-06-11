package com.namai.assurance.model;

import 	javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Date;

@Entity
@Table(name = "paymentdetail")
public class PaymentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private Date paidDate;
	
	@Column(nullable = false)
	private double amount;
	
	@Column(nullable = false, columnDefinition = "varchar(100)")
	private String paymentMethod;
	
	@Column(columnDefinition = "varchar(50)")
	private String payerFirstName;
	
	@Column(columnDefinition = "varchar(50)")
	private String payerLastName;
	
	@Column(columnDefinition = "varchar(50)")
	private long cardNumber;
	
	@Column(columnDefinition = "varchar(10)")
	private long zipCode;
	
	@Column(columnDefinition = "varchar(10)")
	private Date cardExpireDate;
	
	@Column(columnDefinition = "varchar(20)")
	private String cardType;
	
	@Column(columnDefinition = "varchar(50)")
	private String debitOrCredit;
	
	@Column(columnDefinition = "varchar(100)")
	private String bankName;
	
	@Column(columnDefinition = "varchar(20)")
	private long accountNumber;
	
	@Column(columnDefinition = "varchar(20)")
	private long routingNumber;
	
	@Column(columnDefinition = "varchar(20)")
	private long checkNumber;
	
	@Column
	private String checkImage;
	
	@Column
	private String additionalInfos;
	
	@Column(nullable = false)
	private Date createdDate;

	@JsonBackReference(value = "paymentdetail")
	@ManyToOne
	@JoinColumn(name = "bill_id")
	private Bill bill;

	public Bill getBill() { return bill; }
	public void setBill(Bill bill) { this.bill = bill; }

	public PaymentDetail() {}

	public PaymentDetail(long id, Date paidDate, double amount, String paymentMethod, String payerFirstName, String payerLastName, 
			long cardNumber, long zipCode, Date cardExpireDate, String cardType, String debitOrCredit, String bankName, 
			long accountNumber, long routingNumber, long checkNumber, String checkImage, String additionalInfos, Date createdDate, Bill bill) {
		super();
		this.id = id;
		this.paidDate = paidDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.payerFirstName = payerFirstName;
		this.payerLastName = payerLastName;
		
		this.cardNumber = cardNumber;
		this.zipCode = zipCode;
		this.cardExpireDate = cardExpireDate;
		this.cardType = cardType;
		this.debitOrCredit = debitOrCredit;
		this.bankName = bankName;
		
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.checkNumber = checkNumber;
		this.checkImage = checkImage;
		this.additionalInfos = additionalInfos;
		this.createdDate = createdDate;
		
		this.bill = bill;
	}

	public long getId() { return this.id; }
	public void setId(long id) { this.id = id; }

	public Date getPaidDate() { return paidDate; }
	public void setPaidDate(Date paidDate) { this.paidDate = paidDate; }

	public double getAmount() { return amount; }
	public void setAmount(double amount) { this.amount = amount; }

	public String getPaymentMethod() { return paymentMethod; }
	public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

	public String getPayerFirstName() { return payerFirstName; }
	public void setPayerFirstName(String payerFirstName) { this.payerFirstName = payerFirstName; }

	public String getPayerLastName() { return payerLastName; }
	public void setPayerLastName(String payerLastName) { this.payerLastName = payerLastName; }

	
	public long getCardNumber() { return cardNumber; }
	public void setCardNumber(long cardNumber) { this.cardNumber = cardNumber; }
	
	public long getZipCode() { return zipCode; }
	public void setZipCode(long zipCode) { this.zipCode = zipCode; }
	
	public Date getCardExpireDate() { return cardExpireDate; }
	public void setCardExpireDate(Date cardExpireDate) { this.cardExpireDate = cardExpireDate; }
	
	public String getCardType() { return cardType; }
	public void setCardType(String cardType) { this.cardType = cardType; }
	
	public String getDebitOrCredit() { return debitOrCredit; }
	public void setDebitOrCredit(String debitOrCredit) { this.debitOrCredit = debitOrCredit; }
	
	public String getBankName() { return bankName; }
	public void setBankName(String bankName) { this.bankName = bankName; }
	
	
	public long getAccountNumber() { return accountNumber; }
	public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }
	
	public long getRoutingNumber() { return routingNumber; }
	public void setRoutingNumber(long routingNumber) { this.routingNumber = routingNumber; }
	
	public long getCheckNumber() { return checkNumber; }
	public void setCheckNumber(long checkNumber) { this.checkNumber = checkNumber; }
	
	public String getCheckImage() { return checkImage; }
	public void setCheckImage(String checkImage) { this.checkImage = checkImage; }
	
	public String getAdditionalInfos() { return additionalInfos; }
	public void setAdditionalInfos(String additionalInfos) { this.additionalInfos = additionalInfos; }
	
	public Date getCreatedDate() { return createdDate; }
	public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

	@Override
	public String toString() {
		return "PaymentDetail " +
				"[id=" + id +
				", PaidDate=" + paidDate +
				", Amount=" + amount +
				", Payment Method=" + paymentMethod +
				", Payer FirstName=" + payerFirstName +
				", Payer LastName=" + payerLastName +
				", Card Number=" + cardNumber +
				", Zip Code=" + zipCode +
				", Card Expire Date=" + cardExpireDate +
				", Card Type" + cardType +
				", Debit or Credit=" + debitOrCredit +
				", Bank Name=" + bankName +
				", Account Number=" + accountNumber +
				", Routing Number=" + routingNumber +
				", Check Number=" + checkNumber +
				", Check Image=" + checkImage +
				", Additional Infos=" + additionalInfos +
				", Created Date=" + createdDate +
				"]";
	}
}
