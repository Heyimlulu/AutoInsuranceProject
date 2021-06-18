package com.insurance.assurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.assurance.model.PolicyEditLog;

@Repository
public interface PolicyEditLogRepository extends JpaRepository<PolicyEditLog, Long>{
	
	List<PolicyEditLog> findByPolicyId(Long policyId);
	 Optional<PolicyEditLog> findByIdAndPolicyId(Long id, Long policyId);
}
