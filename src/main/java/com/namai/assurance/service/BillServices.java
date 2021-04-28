package com.namai.assurance.service;

import com.namai.assurance.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.namai.assurance.model.Bill;
import com.namai.assurance.repository.BillRepository;

@Service
public class BillServices {
	
	@Autowired BillRepository repository;
	@Autowired private PolicyServices policyServices;

	public PolicyServices getPolicyServices() { return policyServices; }
	public void setPolicyServices(PolicyServices policyServices) { this.policyServices = policyServices; }

	public Bill saveBill(Bill bill) {
		return repository.save(bill);
	}
	
	public List<Bill> getBillInfos(){
		return repository.findAll();
	}
	
	public Optional<Bill> getBillById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedBill(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Bill updateBill(Bill bill) {
		return repository.save(bill);
	}
	
	public void deleteBillById(long id) {
		repository.deleteById(id);
	}
}