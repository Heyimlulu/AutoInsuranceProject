package com.project.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.project.insurance.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
	
	List<Bill> findByPolicyId(Long policyId);
	 Optional<Bill> findByIdAndPolicyId(Long id, Long policyId);
}
