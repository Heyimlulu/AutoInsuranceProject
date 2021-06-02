/*
package com.namai.assurance.controller;

import com.namai.assurance.model.Message;
import com.namai.assurance.model.Coverage;
import com.namai.assurance.model.PolicyCoverage;
import com.namai.assurance.service.PolicyCoverageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policycoverage")
public class PolicyCoverageController {

	@Autowired
	PolicyCoverageServices policyCoverageServices;

	@PostMapping("/create/{id}")
	public ResponseEntity<Message> addNewPolicyCoverage(@RequestBody PolicyCoverage policyCoverage, @PathVariable long id) {
		try {
			Coverage c = policyCoverageServices.getCoverageServices().getCoverageById(id).get();
			policyCoverage.setCoverage(c);
			PolicyCoverage returnedPolicyCoverage = policyCoverageServices.savePolicyCoverage(policyCoverage);

			return new ResponseEntity<Message>(new Message("Upload Successfully!", null, null, null, null, null, null, null, Arrays.asList(returnedPolicyCoverage), null, ""),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Policy Coverage!", null, null, null, null, null, null, null, null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrievePolicyCoverageInfo() {

		try {
			List<PolicyCoverage> policyCoverageInfos = policyCoverageServices.getPolicyCoverageInfos();

			return new ResponseEntity<Message>(new Message("Get Policy Coverage Infos!", null, null, null, null, null, null, null, policyCoverageInfos, null, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getPolicyCoverageId(@PathVariable long id) {
		try {
			Optional<PolicyCoverage> optPolicyCoverage = policyCoverageServices.getPolicyCoverageById(id);

			if (optPolicyCoverage.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a Policy coverage by id = " + id, null, null, null, null, null, null, Arrays.asList(optPolicyCoverage.get()), null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a Policy coverage by id = " + id, null, null, null, null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updatePolicyCoverageById(@RequestBody PolicyCoverage _policyCoverage, @PathVariable long id) {
		try {
			if (policyCoverageServices.checkExistedPolicyCoverage(id)) {
				PolicyCoverage policyCoverage = policyCoverageServices.getPolicyCoverageById(id).get();

				// set new values for coverage
				policyCoverage.setActive(_policyCoverage.getActive());
				policyCoverage.setCreatedDate(_policyCoverage.getCreatedDate());

				// save the change to database
				policyCoverageServices.updatePolicyCoverage(policyCoverage);

				return new ResponseEntity<Message>(
						new Message("Successfully! Updated a Policy coverage " + "with id = " + id,  null, null, null, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Policy Coverage " + "with id = " + id, null, null, null, null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deletePolicyCoverageById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if (policyCoverageServices.checkExistedPolicyCoverage(id)) {
				policyCoverageServices.deletePolicyCoverageById(id);

				return new ResponseEntity<Message>(
						new Message("Successfully! Delete a Policy Coverage with id = " + id, null, null, null, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Policy Coverage " + "with id = " + id, null, null, null, null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
}

 */
