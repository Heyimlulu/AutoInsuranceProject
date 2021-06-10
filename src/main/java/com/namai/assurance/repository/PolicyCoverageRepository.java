package com.namai.assurance.repository;

import com.namai.assurance.model.PolicyCoverage;
import com.namai.assurance.model.PolicyEditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolicyCoverageRepository extends JpaRepository<PolicyCoverage, Long>{
}