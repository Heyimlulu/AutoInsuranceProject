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
import com.namai.assurance.model.PolicyEditLog;
import com.namai.assurance.model.Message;
import com.namai.assurance.service.PolicyEditLogServices; 

@RestController
@RequestMapping("/api/editLog")
public class PolicyEditLogController {

	@Autowired
	PolicyEditLogServices policyEditLogServices;

	@PostMapping("/create/{id}")
	public ResponseEntity<Message> addNewPolicyEditLog(@RequestBody PolicyEditLog policyEditLog, @PathVariable long id) {
		try {
			Policy p = policyEditLogServices.getPolicyServices().getPolicyById(id).get();
			policyEditLog.setPolicy(p);
			PolicyEditLog returnedPolicy = policyEditLogServices.savePolicyEditLog(policyEditLog);

			return new ResponseEntity<Message>(new Message("Upload Successfully!", null, Arrays.asList(returnedPolicy), null, null, null, null, ""),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Policy!", null, null, null, null, null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrievePolicyEditLogInfo() {

		try {
			List<PolicyEditLog> policyEditLogInfos = policyEditLogServices.getPolicyEditLogInfos();

			return new ResponseEntity<Message>(new Message("Get Policys Edit Log' Infos!", null, policyEditLogInfos, null, null, null, null, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getPolicyEditLogById(@PathVariable long id) {
		try {
			Optional<PolicyEditLog> optPolicy = policyEditLogServices.getPolicyEditLogById(id);

			if (optPolicy.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a policy by id = " + id,
						null, Arrays.asList(optPolicy.get()), null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a policy by id = " + id, null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updatePolicyById(@RequestBody PolicyEditLog _policyEditLog, @PathVariable long id) {
		try {
			if (policyEditLogServices.checkExistedPolicyEditLog(id)) {
				PolicyEditLog policyEditLog = policyEditLogServices.getPolicyEditLogById(id).get();

				// set new values for policy
				policyEditLog.setEditedTableName(_policyEditLog.getEditedTableName());
				policyEditLog.setAdditionalInfos(_policyEditLog.getAdditionalInfos());
				policyEditLog.setEditedBy(_policyEditLog.getEditedBy());
				policyEditLog.setEditedDate(_policyEditLog.getEditedDate());

				// save the change to database
				policyEditLogServices.updatePolicyEditLog(policyEditLog);

				return new ResponseEntity<Message>(
						new Message("Successfully! Updated a PolicyEditLog " + "with id = " + id, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Policy " + "with id = " + id, null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deletePolicyById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if (policyEditLogServices.checkExistedPolicyEditLog(id)) {
				policyEditLogServices.deletePolicyEditLogById(id);

				return new ResponseEntity<Message>(
						new Message("Successfully! Delete a PolicyEditLog with id = " + id, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a PolicyEditLog " + "with id = " + id,  null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure",  null, null, null, null, null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
