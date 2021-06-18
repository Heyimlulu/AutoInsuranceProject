package com.insurance.assurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.assurance.model.PolicyEditLog;
import com.insurance.assurance.repository.PolicyEditLogRepository;

@Service
public class PolicyEditLogServices {
	
	@Autowired PolicyEditLogRepository repository;
	@Autowired private PolicyServices policyServices;
	
	public PolicyServices getPolicyServices() {
		return policyServices;
	}
	public void setPolicyServices(PolicyServices policyServices) {
		this.policyServices = policyServices;
	}

	public PolicyEditLog savePolicyEditLog(PolicyEditLog policyEditLog) {
		return repository.save(policyEditLog);
	}
	
	public List<PolicyEditLog> getPolicyEditLogInfos(){
		return repository.findAll();
	}
	
	public Optional<PolicyEditLog> getPolicyEditLogById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedPolicyEditLog(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public PolicyEditLog updatePolicyEditLog(PolicyEditLog policyEditLog) {
		return repository.save(policyEditLog);		
	}
	
	public void deletePolicyEditLogById(long id) {
		repository.deleteById(id);
	}
}