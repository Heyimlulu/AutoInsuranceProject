package com.namai.assurance.controller;

import com.namai.assurance.model.Message;
import com.namai.assurance.model.Coverage;
import com.namai.assurance.service.CoverageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coverage")
public class CoverageController {

	@Autowired
	CoverageServices coverageServices;

	@PostMapping("/create/{id}")
	public ResponseEntity<Message> addNewCoverage(@RequestBody Coverage coverage) {
		try {
			Coverage returnedCoverage = coverageServices.saveCoverage(coverage);

			return new ResponseEntity<Message>(new Message("Upload Successfully!", Arrays.asList(returnedCoverage), ""),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Coverage!", null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrieveCoverageInfo() {

		try {
			List<Coverage> coverageInfos = coverageServices.getCoverageInfos();

			return new ResponseEntity<Message>(new Message("Get Coverage Edit Log' Infos!", coverageInfos, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getCoverageId(@PathVariable long id) {
		try {
			Optional<Coverage> optCoverage = coverageServices.getCoverageById(id);

			if (optCoverage.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a coverage by id = " + id, Arrays.asList(optCoverage.get()), ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a coverage by id = " + id, null,""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updateCoverageById(@RequestBody Coverage _coverage, @PathVariable long id) {
		try {
			if (coverageServices.checkExistedCoverage(id)) {
				Coverage coverage = coverageServices.getCoverageById(id).get();

				// set new values for coverage
				coverage.setCoverageName(_coverage.getCoverageName());
				coverage.setCoverageGroup(_coverage.getCoverageGroup());
				coverage.setCode(_coverage.getCode());
				coverage.setIsPolicyCoverage(_coverage.getIsPolicyCoverage());
				coverage.setSsVehicleCoverage(_coverage.getSsVehicleCoverage());
				coverage.setDescription(_coverage.getDescription());

				// save the change to database
				coverageServices.updateCoverage(coverage);

				return new ResponseEntity<Message>(
						new Message("Successfully! Updated a <coverage " + "with id = " + id, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Coverage " + "with id = " + id, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deleteCoverageById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if (coverageServices.checkExistedCoverage(id)) {
				coverageServices.deleteCoverageById(id);

				return new ResponseEntity<Message>(
						new Message("Successfully! Delete a Coverage with id = " + id, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Coverage " + "with id = " + id,  null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
}
