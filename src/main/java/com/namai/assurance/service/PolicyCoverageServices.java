/*
package com.namai.assurance.service;

import com.namai.assurance.model.PolicyCoverage;
import com.namai.assurance.repository.PolicyCoverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyCoverageServices {
	
	@Autowired PolicyCoverageRepository repository;
	@Autowired private CoverageServices coverageServices;
	
	public CoverageServices getCoverageServices() { return coverageServices; }
	public void setCoverageServices(CoverageServices coverageServices) { this.coverageServices = coverageServices; }

	public PolicyCoverage savePolicyCoverage(PolicyCoverage policyCoverage) {
		return repository.save(policyCoverage);
	}
	
	public List<PolicyCoverage> getPolicyCoverageInfos(){
		return repository.findAll();
	}
	
	public Optional<PolicyCoverage> getPolicyCoverageById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedPolicyCoverage(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public PolicyCoverage updatePolicyCoverage(PolicyCoverage policyCoverage) {
		return repository.save(policyCoverage);
	}
	
	public void deletePolicyCoverageById(long id) {
		repository.deleteById(id);
	}
}

 */