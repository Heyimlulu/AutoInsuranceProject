package com.namai.assurance.service;

import com.namai.assurance.model.VehicleCoverage;
import com.namai.assurance.repository.VehicleCoverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleCoverageServices {
	
	@Autowired VehicleCoverageRepository repository;
	@Autowired private CoverageServices coverageServices;
	
	public CoverageServices getCoverageServices() { return coverageServices; }
	public void setCoverageServices(CoverageServices coverageServices) { this.coverageServices = coverageServices; }

	public VehicleCoverage saveVehicleCoverage(VehicleCoverage vehicleCoverage) {
		return repository.save(vehicleCoverage);
	}
	
	public List<VehicleCoverage> getVehicleCoverageInfos(){
		return repository.findAll();
	}
	
	public Optional<VehicleCoverage> getVehicleCoverageById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedVehicleCoverage(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public VehicleCoverage updateVehicleCoverage(VehicleCoverage vehicleCoverage) {
		return repository.save(vehicleCoverage);
	}
	
	public void deleteVehicleCoverageById(long id) {
		repository.deleteById(id);
	}
}