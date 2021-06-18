package com.insurance.assurance.repository;

import com.insurance.assurance.model.Coverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverageRepository extends JpaRepository<Coverage, Long>{
}
