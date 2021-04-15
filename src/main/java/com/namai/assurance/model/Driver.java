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
	private Date dob;
	
	@Column
	private long policy_id_artifact;

	@Column
	private String email_adress;

	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	private long phone_number;

	@Column
	private String ssn;
	
	@Column
	private String title;
	
	@Column
	private String middleInitial;
	
	@Column
	private Date license_issue_date;

	@Column
	private String license_issue_state;
	
	@Column
	private long license_number;

	@Column
	private String gender;

	@Column
	private String marital_statut;

	@Column
	private Boolean is_primary_policy_holder;

	@Column
	private String relation_withPrimary_policy_holder;
	
	@Column
	private Date created_date;
	
	@Column 
	private long cellNumber;
	
	@Column
	private Boolean active;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	private Policy policy;

	public Policy getPolicy() { return policy; }
	public void setPolicy(Policy policy) { this.policy = policy; }

	public Driver() {}

	public Driver(long id, String title, String first_name, String last_name, String middleInitial, Date dob, String email_adress, long phone_number, long cellNumber, String ssn, Date license_issue_date, 
							long license_number, String license_issue_state, long policy_id_artifact, Boolean is_primary_policy_holder, String relation_withPrimary_policy_holder, String gender, String marital_statut, Date created_date, Boolean active , Policy policy) {
		
		
		this.id = id;
		this.dob = dob;
		this.email_adress = email_adress;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.ssn = ssn;
		this.title = title;
		this.middleInitial = middleInitial;
		this.license_issue_date = license_issue_date;
		this.license_number = license_number;
		this.license_issue_state = license_issue_state;
		this.gender = gender;
		this.marital_statut = marital_statut;
		this.created_date = created_date;
		this.is_primary_policy_holder = is_primary_policy_holder;
		this.relation_withPrimary_policy_holder = relation_withPrimary_policy_holder;
		this.policy_id_artifact = policy_id_artifact;
		this.active = active;
		this.cellNumber = cellNumber;
		this.policy = policy;
	}

	
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getPolicy_id_artifact() {
		return policy_id_artifact;
	}
	public void setPolicy_id_artifact(long policy_id_artifact) {
		this.policy_id_artifact = policy_id_artifact;
	}
	public String getEmail_adress() {
		return email_adress;
	}
	public void setEmail_adress(String email_adress) {
		this.email_adress = email_adress;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public Date getLicense_issue_date() {
		return license_issue_date;
	}
	public void setLicense_issue_date(Date license_issue_date) {
		this.license_issue_date = license_issue_date;
	}
	public String getLicense_issue_state() {
		return license_issue_state;
	}
	public void setLicense_issue_state(String license_issue_state) {
		this.license_issue_state = license_issue_state;
	}
	public long getLicense_number() {
		return license_number;
	}
	public void setLicense_number(long license_number) {
		this.license_number = license_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMarital_statut() {
		return marital_statut;
	}
	public void setMarital_statut(String marital_statut) {
		this.marital_statut = marital_statut;
	}
	public Boolean getIs_primary_policy_holder() {
		return is_primary_policy_holder;
	}
	public void setIs_primary_policy_holder(Boolean is_primary_policy_holder) {
		this.is_primary_policy_holder = is_primary_policy_holder;
	}
	public String getRelation_withPrimary_policy_holder() {
		return relation_withPrimary_policy_holder;
	}
	public void setRelation_withPrimary_policy_holder(String relation_withPrimary_policy_holder) {
		this.relation_withPrimary_policy_holder = relation_withPrimary_policy_holder;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public long getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(long cellNumber) {
		this.cellNumber = cellNumber;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public boolean getActive() { return active; }
	public void setActive(boolean active) { this.active = active; }


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", title=" + title	+ ", first_name=" + first_name + ", last_name=" + last_name + ", middleInitial=" + middleInitial + ", dob=" + dob +
				", email_adress=" + email_adress + ", phone_number=" + phone_number + ", cellNumber=" + cellNumber + ", ssn" + ssn + ", license_issue_date=" + license_issue_date + ", license_number=" + license_number +  ", is_primary_policy_holder=" + is_primary_policy_holder + 
				", relation_withPrimary_policy_holder=" + relation_withPrimary_policy_holder + ", marital_statut=" + marital_statut + ", gender=" + gender + ", policy_id_artifact=" + policy_id_artifact + ", license_issue_state=" + license_issue_state + ", Active=" + active + "]";
	}
}
