package com.project.insurance.service;

import com.project.insurance.model.Coverage;
import com.project.insurance.repository.CoverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoverageServices {
	
	@Autowired CoverageRepository repository;
	@Autowired private PolicyServices policyServices; //

	public PolicyServices getPolicyServices() {
		return policyServices;
	} //
	public void setPolicyServices(PolicyServices policyServices) {
		this.policyServices = policyServices;
	} //

	public Coverage saveCoverage(Coverage coverage) {
		return repository.save(coverage);
	}
	
	public List<Coverage> getCoverageInfos(){
		return repository.findAll();
	}
	
	public Optional<Coverage> getCoverageById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedCoverage(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Coverage updateCoverage(Coverage coverage) {
		return repository.save(coverage);
	}

	public void deleteCoverageById(long id) {
		repository.deleteById(id);
	}
}