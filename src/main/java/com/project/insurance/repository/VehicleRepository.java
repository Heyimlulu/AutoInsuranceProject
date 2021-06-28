package com.project.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.project.insurance.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	
	List<Vehicle> findByPolicyId(Long policyId);
	 Optional<Vehicle> findByIdAndPolicyId(Long id, Long policyId);
}
