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
	private List<PolicyCoverage> policyCoverage = new ArrayList<PolicyCoverage>();
	private List<VehicleCoverage> vehicleCoverage = new ArrayList<VehicleCoverage>();
	private String error = "";

	/*
	 * ======== Message, Error and Policys ========
	 */
	
	public String getMessage() { return this.message; }
	public void setMessage(String message) { this.message = message; }
	
	public String getError() { return this.error; }
	public void setError(String error) { this.error = error; }
	
	public List<Policy> getPolicys() { return this.policies; }
	public void setPolicys(ArrayList<Policy> policys) { this.policies = policys; }
	
	/*
	 * ======== Tables ========
	 */
	
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

	public List<PolicyCoverage> getPolicyCoverage() { return policyCoverage; }
	public void setPolicyCoverage(List<PolicyCoverage> policyCoverage) { this.policyCoverage = policyCoverage; }

	public List<VehicleCoverage> getVehicleCoverage() { return vehicleCoverage; }
	public void setVehicleCoverage(List<VehicleCoverage> vehicleCoverage) { this.vehicleCoverage = vehicleCoverage; }

	/*
	 * ======== Constructors ========
	 */
	
	public Message(String message, List<Policy> policies, List<PolicyEditLog> editLogPolicies, List<Bill> bill, 
			List<PaymentDetail> paymentDetail, List<Vehicle> vehicle, List<Driver> driver, List<Coverage> coverage,
				   List<PolicyCoverage> policyCoverage, List<VehicleCoverage> vehicleCoverage, String error) {
		this.message = message;
		this.policies = policies;
		this.editLogPolicies = editLogPolicies;
		this.bill = bill;
		this.paymentDetail = paymentDetail;
		this.vehicle = vehicle;
		this.driver = driver;
		this.coverage = coverage;
		this.policyCoverage = policyCoverage;
		this.vehicleCoverage = vehicleCoverage;
		this.error = error;
	}
	
	public Message(String message, List<PolicyEditLog> editLogPolicies, List<Bill> bill, 
			List<PaymentDetail> paymentDetail, List<Vehicle> vehicle, List<Driver> driver, List<Coverage> coverage,
				   List<PolicyCoverage> policyCoverage, List<VehicleCoverage> vehicleCoverage, String error) {
		this.message = message;
		this.editLogPolicies = editLogPolicies;
		this.bill = bill;
		this.paymentDetail = paymentDetail;
		this.vehicle = vehicle;
		this.driver = driver;
		this.coverage = coverage;
		this.policyCoverage = policyCoverage;
		this.vehicleCoverage = vehicleCoverage;
		this.error = error;
	}

}
