package com.namai.assurance.repository;

import com.namai.assurance.model.VehicleCoverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleCoverageRepository extends JpaRepository<VehicleCoverage, Long>{
    List<VehicleCoverage> findByCoverageId(Long coverageId);
    Optional<VehicleCoverage> findByIdAndCoverageId(Long id, Long coverageId);
}
