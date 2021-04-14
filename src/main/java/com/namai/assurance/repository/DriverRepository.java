package com.namai.assurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namai.assurance.model.Driver;
import com.namai.assurance.model.Policy;
import com.namai.assurance.model.PolicyEditLog;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
	List<Driver> findByPolicyId(Long policyId);
	 Optional<Driver> findByIdAndPolicyId(Long id, Long policyId);
}
