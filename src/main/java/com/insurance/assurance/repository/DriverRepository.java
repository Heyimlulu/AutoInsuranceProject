package com.insurance.assurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.assurance.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
	List<Driver> findByPolicyId(Long policyId);
	 Optional<Driver> findByIdAndPolicyId(Long id, Long policyId);
}
