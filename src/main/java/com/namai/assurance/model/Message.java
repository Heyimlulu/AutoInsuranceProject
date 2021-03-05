package com.namai.assurance.model;

import java.util.ArrayList;
import java.util.List;

public class Message {
	private String message = "";
	private List<Policy> policies = new ArrayList<Policy>();
	private List<PolicyEditLog> editLogPolicies = new ArrayList<PolicyEditLog>();
	private List<Bill> bill = new ArrayList<Bill>();
	private List<PaymentDetail> paymentDetail = new ArrayList<PaymentDetail>();
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
	

	public Message(String message, List<Policy> policies, List<PolicyEditLog> editLogPolicies, List<Bill> bill, List<PaymentDetail> paymentDetail, String error) {
		this.message = message;
		this.policies = policies;
		this.editLogPolicies = editLogPolicies;
		this.bill = bill;
		this.paymentDetail = paymentDetail;
		this.error = error;
	}

	
	public Message(String message, List<PolicyEditLog> editLogPolicies, List<Bill> bill, List<PaymentDetail> paymentDetail, String error) {
		this.message = message;
		this.editLogPolicies = editLogPolicies;
		this.bill = bill;
		this.paymentDetail = paymentDetail;
		this.error = error;
	}
}
