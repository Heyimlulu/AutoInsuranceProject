package com.project.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.project.insurance.model.Vehicle;
import com.project.insurance.repository.VehicleRepository;

@Service
public class VehicleServices {
	
	@Autowired VehicleRepository repository;
	@Autowired private PolicyServices policyServices;
	
	public PolicyServices getPolicyServices() { return policyServices; }
	public void setPolicyServices(PolicyServices policyServices) { this.policyServices = policyServices; }

	public Vehicle saveVehicle(Vehicle vehicle) {
		return repository.save(vehicle);
	}
	
	public List<Vehicle> getVehicleInfos(){
		return repository.findAll();
	}
	
	public Optional<Vehicle> getVehicleById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedVehicle(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Vehicle updateVehicle(Vehicle vehicle) {
		return repository.save(vehicle);
	}
	
	public void deleteVehicleById(long id) {
		repository.deleteById(id);
	}
}