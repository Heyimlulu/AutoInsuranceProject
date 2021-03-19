package com.namai.assurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.namai.assurance.model.PaymentDetail;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long>{
	
	List<PaymentDetail> findByBillId(Long billId);
	 Optional<PaymentDetail> findByIdAndBillId(Long id, Long billId);
}
