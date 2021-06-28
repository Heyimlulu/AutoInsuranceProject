package com.project.insurance.service;

import com.project.insurance.repository.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.project.insurance.model.PaymentDetail;

@Service
public class PaymentDetailServices {
	
	@Autowired PaymentDetailRepository repository;
	@Autowired private BillServices billServices;
	
	public BillServices getBillServices() { return billServices; }
	public void setBillServices(BillServices billServices) { this.billServices = billServices; }

	public PaymentDetail savePaymentDetail(PaymentDetail paymentDetail) {
		return repository.save(paymentDetail);
	}
	
	public List<PaymentDetail> getPaymentDetailInfos(){
		return repository.findAll();
	}
	
	public Optional<PaymentDetail> getPaymentDetailById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedPaymentDetail(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public PaymentDetail updatePaymentDetail(PaymentDetail paymentDetail) {
		return repository.save(paymentDetail);
	}
	
	public void deletePaymentDetailById(long id) {
		repository.deleteById(id);
	}
}