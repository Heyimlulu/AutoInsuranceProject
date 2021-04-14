package com.namai.assurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namai.assurance.model.Driver;
import com.namai.assurance.model.Policy;
import com.namai.assurance.repository.DriverRepository;
import com.namai.assurance.repository.PolicyRepository;

@Service
public class DriverServices {
	
	@Autowired DriverRepository repository;
	@Autowired private PolicyServices policyServices;
	
	public DriverRepository getRepository() {
		return repository;
	}

	public void setRepository(DriverRepository repository) {
		this.repository = repository;
	}

	public PolicyServices getPolicyServices() {
		return policyServices;
	}

	public void setPolicyServices(PolicyServices policyServices) {
		this.policyServices = policyServices;
	}

	public Driver saveDriver(Driver driver) {
		return repository.save(driver);
	}
	
	public List<Driver> getDriverInfos(){
		return repository.findAll();
	}
	
	public Optional<Driver> getPolicyById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedDriver(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Driver updateDriver(Driver driver) {
		return repository.save(driver);		
	}
	
	public void deleteDriverById(long id) {
		repository.deleteById(id);
	}
}
