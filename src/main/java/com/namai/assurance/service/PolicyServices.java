package com.namai.assurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namai.assurance.model.Policy;
import com.namai.assurance.repository.PolicyRepository;

@Service
public class PolicyServices {
	
	@Autowired PolicyRepository repository;
	
	public Policy savePolicy(Policy policy) {
		return repository.save(policy);
	}
	
	public List<Policy> getPolicyInfos(){
		return repository.findAll();
	}
	
	public Optional<Policy> getPolicyById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedPolicy(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Policy updatePolicy(Policy policy) {
		return repository.save(policy);		
	}
	
	public void deletePolicyById(long id) {
		repository.deleteById(id);
	}
}
