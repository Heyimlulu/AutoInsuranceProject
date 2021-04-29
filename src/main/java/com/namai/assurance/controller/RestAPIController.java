package com.namai.assurance.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namai.assurance.model.Policy;
import com.namai.assurance.model.Message;
import com.namai.assurance.service.PolicyServices;

@RestController
@RequestMapping("/api/policy")
public class RestAPIController {
	
	@Autowired
	PolicyServices policyServices;
	
	@PostMapping("/create")
	public ResponseEntity<Message> addNewPolicy(@RequestBody Policy policy) {
		try {
			Policy returnedPolicy = policyServices.savePolicy(policy);
			
			return new ResponseEntity<Message>(new Message("Upload Successfully!", Arrays.asList(returnedPolicy), null, null, null, null, null, null, ""), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Policy!", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrievePolicyInfo() {
		
		try {
			List<Policy> policyInfos = policyServices.getPolicyInfos();
			
			return new ResponseEntity<Message>(new Message("Get Policys' Infos!", policyInfos, null, null, null, null, null, null, ""), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, null, null, null,null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getPolicyById(@PathVariable long id) {
		try {
			Optional<Policy> optPolicy = policyServices.getPolicyById(id);
			
			if(optPolicy.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a policy by id = " + id,
															Arrays.asList(optPolicy.get()), null, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a policy by id = " + id,
						null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updatePolicyById(@RequestBody Policy _policy, @PathVariable long id) {
		try {
			if(policyServices.checkExistedPolicy(id)) {
				Policy policy = policyServices.getPolicyById(id).get();
				
				//set new values for policy
				policy.setPolicyNumber(_policy.getPolicyNumber());
				policy.setAdditionalInfos(_policy.getAdditionalInfos());
				policy.setCreationDate(_policy.getCreationDate());
				policy.setPaymentOption(_policy.getPaymentOption());
				policy.setActive(_policy.isActive());
				policy.setPolicyEffectiveDate(_policy.getPolicyEffectiveDate());
				policy.setPolicyExpireDate(_policy.getPolicyExpireDate());
				policy.setTotalAmount(_policy.getTotalAmount());
				
	
				// save the change to database
				policyServices.updatePolicy(policy);
				
				return new ResponseEntity<Message>(new Message("Successfully! Updated a Policy " + "with id = " + id, Arrays.asList(policy), null, null, null, null, null, null, ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Policy " + "with id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deletePolicyById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if(policyServices.checkExistedPolicy(id)) {
				policyServices.deletePolicyById(id);
				
				return new ResponseEntity<Message> (new Message("Successfully! Delete a Policy with id = " + id, null, null, null, null, null, null, ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Policy " + "with id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
