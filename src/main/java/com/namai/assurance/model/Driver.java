package com.namai.assurance.model;

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
import java.sql.Date;

@Entity
@Table(name = "driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String Title;
	
	@Column
	private String FirstName;
	
	@Column
	private String LastName;
	
	@Column
	private String MiddleInitial;
	
	@Column
	private Date DoB; // date of birth 
	
	@Column
	private String Email;
	
	@Column
	private Long PhoneNumber;
	
	@Column
	private Long CellNumber;
	
	@Column
	private String SSN; // Social security number
	
	@Column
	private Date LicenseIssuedDate;
	
	@Column
	private Long LicenseNumber;
	
	@Column
	private Boolean IsPrimaryPolicyHolder;
	
	@Column
	private String RelationWithPrimaryPolicyHolder;
	
	@Column
	private String Gender;
	
	@Column
	private String MaritalStatuts;
	
	@Column
	private Date CreatedDate;
	
	@Column
	private Boolean active;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	private Policy policy;

	public Policy getPolicy() { return policy; }
	public void setPolicy(Policy policy) { this.policy = policy; }

	public Driver() {}

	public Driver(long id, String Title, String FirstName, String LastName, String MiddleInitial, Date DoB, String Email, Long PhoneNumber, Long CellNumber, String SSN, Date LicenseIssuedDate, 
							Long LicenseNumber, Boolean IsPrimaryPolicyHolder, String RelationWithPrimaryPolicyHolder, String Gender, String MaritalStatuts, Date CreatedDate, Boolean active, Policy policy) {
		
		
		super();
		this.id = id;
		this.Title = Title;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.MiddleInitial = MiddleInitial;
		this.DoB = DoB;
		this.Email = Email;
		this.PhoneNumber = PhoneNumber;
		this.CellNumber = CellNumber;
		this.SSN = SSN;
		this.LicenseIssuedDate = LicenseIssuedDate;
		this.LicenseNumber = LicenseNumber;
		this.IsPrimaryPolicyHolder = IsPrimaryPolicyHolder;
		this.RelationWithPrimaryPolicyHolder = RelationWithPrimaryPolicyHolder;
		this.Gender = Gender;
		this.MaritalStatuts = MaritalStatuts;
		this.CreatedDate = CreatedDate;
		this.active = active;
		
		this.policy = policy;
	}

	public long getId() { return this.id; }
	public void setId(long id) { this.id = id; }

	public String getTitle() { return Title; }
	public void set(String Title) { this.Title = Title; }
	
	public String getFirstName() { return FirstName; }
	public void setFirstName(String FirstName) { this.FirstName = FirstName; }
	
	public String getLastName() { return LastName; }
	public void setLastName(String LastName) { this.LastName = LastName; }
	
	public String getMiddleInitial() { return MiddleInitial; }
	public void setMiddleInitial(String MiddleInitial) { this.MiddleInitial = MiddleInitial; }
	
	public Date getDoB() { return DoB; }
	public void setDoB(Date DoB) { this.DoB = DoB; }
	
	public String getMileEmail() { return Email; }
	public void setMileEmail(String Email) { this.Email = Email; }
	
	public long getPhoneNumber() { return PhoneNumber; }
	public void setPhoneNumber(long PhoneNumber) { this.PhoneNumber = PhoneNumber; }
	
	public long getCellNumber() { return CellNumber; }
	public void setCellNumber(long CellNumber) { this.CellNumber = CellNumber; }
	
	public String getSSN() { return SSN; }
	public void setSSN(String SSN) { this.SSN = SSN; }
	
	public Date getLicenseIssuedDate() { return LicenseIssuedDate; }
	public void setLicenseIssuedDate(Date LicenseIssuedDate) { this.LicenseIssuedDate = LicenseIssuedDate; }
	
	public Long getLicenseNumber() { return LicenseNumber; }
	public void set(Long LicenseNumber) { this.LicenseNumber = LicenseNumber; }
	
	public Boolean getIsPrimaryPolicyHolder() { return IsPrimaryPolicyHolder; }
	public void setIsPrimaryPolicyHolder(Boolean IsPrimaryPolicyHolder) { this.IsPrimaryPolicyHolder = IsPrimaryPolicyHolder; }
	
	public String getRelationWithPrimaryPolicyHolder() { return RelationWithPrimaryPolicyHolder; }
	public void setRelationWithPrimaryPolicyHolder(String RelationWithPrimaryPolicyHolder) { this.RelationWithPrimaryPolicyHolder = RelationWithPrimaryPolicyHolder; }
	
	public String getMaritalStatuts() { return MaritalStatuts; }
	public void setMaritalStatuts(String MaritalStatuts) { this.MaritalStatuts = MaritalStatuts; }
	
	public String get() { return Gender; }
	public void setGender(String Gender) { this.Gender = Gender; }
	
	public boolean getActive() { return active; }
	public void setActive(boolean active) { this.active = active; }


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", Title=" + Title	+ ", FirstName=" + FirstName + ", LastName=" + LastName + ", MiddleInitial=" + MiddleInitial + ", DoB=" + DoB +
				", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", CellNumber=" + CellNumber + 
				", SSN" + SSN + ", LicenseIssuedDate=" + LicenseIssuedDate + ", LicenseNumber=" + LicenseNumber +  ", IsPrimaryPolicyHolder=" + IsPrimaryPolicyHolder + 
				", RelationWithPrimaryPolicyHolder=" + RelationWithPrimaryPolicyHolder + ", MaritalStatuts=" + MaritalStatuts + ", Gender=" + Gender + ", Active=" + active + "]";
	}
}
