package com.namai.assurance.model;

import java.util.ArrayList;
import java.util.List;

public class Message {
	private String message = "";
	private List<Policy> policies = new ArrayList<Policy>();
	private List<PolicyEditLog> editLogPolicies = new ArrayList<PolicyEditLog>();
	private String error = "";
	
	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public List<PolicyEditLog> getEditLogPolicies() {
		return editLogPolicies;
	}

	public void setEditLogPolicies(List<PolicyEditLog> editLogPolicies) {
		this.editLogPolicies = editLogPolicies;
	}

	public Message(String message, List<Policy> policies, List<PolicyEditLog> editLogPolicies, String error) {
		this.message = message;
		this.policies = policies;
		this.editLogPolicies = editLogPolicies;
		this.error = error;
	}
	
	public Message(String message, List<PolicyEditLog> editLogPolicies, String error) {
		this.message = message;
		this.editLogPolicies = editLogPolicies;
		this.error = error;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Policy> getPolicys(){
		return this.policies;
	}
	
	public void setPolicys(ArrayList<Policy> policys) {
		this.policies = policys;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}
}
