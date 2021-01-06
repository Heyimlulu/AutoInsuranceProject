package com.namai.assurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namai.assurance.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>{
}
