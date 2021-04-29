package com.namai.assurance.model;

import java.util.ArrayList;
import java.util.List;

public class Message {
	private String message = "";
	private List<Policy> policies = new ArrayList<Policy>();
	private List<PolicyEditLog> editLogPolicies = new ArrayList<PolicyEditLog>();
	private List<Bill> bill = new ArrayList<Bill>();
	private List<PaymentDetail> paymentDetail = new ArrayList<PaymentDetail>();
	private List<Vehicle> vehicle = new ArrayList<Vehicle>();
	private List<Driver> driver = new ArrayList<Driver>();
	private List<Coverage> coverage = new ArrayList<Coverage>();
	private String error = "";

	public String getMessage() { return this.message; }
	public void setMessage(String message) { this.message = message; }
	
	public List<Policy> getPolicys(){ return this.policies; }
	public void setPolicys(ArrayList<Policy> policys) { this.policies = policys; }
	
	public String getError() { return this.error; }
	public void setError(String error) { this.error = error; }
	
	public List<Policy> getPolicies() {	return policies; }
	public void setPolicies(List<Policy> policies) { this.policies = policies; }

	public List<PolicyEditLog> getEditLogPolicies() { return editLogPolicies; }
	public void setEditLogPolicies(List<PolicyEditLog> editLogPolicies) { this.editLogPolicies = editLogPolicies; }
	
	public List<Bill> getBill() { return bill; }
	public void setBill(List<Bill> bill) { this.bill = bill; }
	
	public List<PaymentDetail> getPaymentDetail() { return paymentDetail; }
	public void setPaymentDetail(List<PaymentDetail> paymentDetail) { this.paymentDetail = paymentDetail; }
	
	public List<Vehicle> getVehicle() { return vehicle; }
	public void setVehicle(List<Vehicle> vehicle) { this.vehicle = vehicle; }
	
	public List<Driver> getDrivers() { return driver; }
	public void setDriver(List<Driver> driver) { this.driver = driver; }
	
	public List<Coverage> getCoverage() { return coverage; }
	public void setCoverage(List<Coverage> coverage) { this.coverage = coverage; }
	
	public Message(String message, List<Policy> policies, List<PolicyEditLog> editLogPolicies, List<Bill> bill, List<Vehicle> vehicle, List<Driver> driver, String error) {
		this.message = message;
		this.policies = policies;
		this.editLogPolicies = editLogPolicies;
		this.bill = bill;
		this.vehicle = vehicle;
		this.driver = driver;
		this.error = error;
	}
	
	public Message(String message, List<Bill> bill, List<PaymentDetail> paymentDetail, String error) {
		super();
		this.message = message;
		this.bill = bill;
		this.paymentDetail = paymentDetail;
		this.error = error;
	}
	
	public Message(String message, List<Coverage> coverage, String error) {
		super();
		this.message = message;
		this.coverage = coverage;
		this.error = error;
	}
	
	

}
