package com.namai.assurance.controller;

import com.namai.assurance.model.Message;
import com.namai.assurance.model.PolicyCoverage;
import com.namai.assurance.model.Coverage;
import com.namai.assurance.model.VehicleCoverage;
import com.namai.assurance.service.VehicleCoverageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiclecoverage")
public class VehicleCoverageController {

	@Autowired
	VehicleCoverageServices vehicleCoverageServices;

	@PostMapping("/create/{id}")
	public ResponseEntity<Message> addNewCoverage(@RequestBody VehicleCoverage vehicleCoverage, @PathVariable long id) {
		try {
			Coverage c = vehicleCoverageServices.getCoverageServices().getCoverageById(id).get();
			vehicleCoverage.setCoverage(c);
			VehicleCoverage returnedVehicleCoverage = vehicleCoverageServices.saveVehicleCoverage(vehicleCoverage);

			return new ResponseEntity<Message>(new Message("Upload Successfully!", null, null, null, null, null, null, null, null, Arrays.asList(returnedVehicleCoverage), ""),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Vehicle Coverage!", null, null, null, null, null, null, null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrieveCoverageInfo() {

		try {
			List<VehicleCoverage> vehicleCoverageInfos = vehicleCoverageServices.getVehicleCoverageInfos();

			return new ResponseEntity<Message>(new Message("Get Vehicle Coverage Infos!", null, null, null, null, null, null, null, null, vehicleCoverageInfos, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getCoverageId(@PathVariable long id) {
		try {
			Optional<VehicleCoverage> optVehicleCoverage = vehicleCoverageServices.getVehicleCoverageById(id);

			if (optVehicleCoverage.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a Vehicle coverage by id = " + id, null, null, null, null, null, null, Arrays.asList(optVehicleCoverage.get()), ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a Vehicle coverage by id = " + id, null, null, null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updateCoverageById(@RequestBody VehicleCoverage _vehicleCoverage, @PathVariable long id) {
		try {
			if (vehicleCoverageServices.checkExistedVehicleCoverage(id)) {
				VehicleCoverage vehicleCoverage = vehicleCoverageServices.getVehicleCoverageById(id).get();

				// set new values for coverage
				vehicleCoverage.setActive(_vehicleCoverage.getActive());
				vehicleCoverage.setCreatedDate(_vehicleCoverage.getCreatedDate());

				// save the change to database
				vehicleCoverageServices.updateVehicleCoverage(vehicleCoverage);

				return new ResponseEntity<Message>(
						new Message("Successfully! Updated a Vehicle coverage " + "with id = " + id, null, null, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Vehicle Coverage " + "with id = " + id, null, null, null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deleteCoverageById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if (vehicleCoverageServices.checkExistedVehicleCoverage(id)) {
				vehicleCoverageServices.deleteVehicleCoverageById(id);

				return new ResponseEntity<Message>(
						new Message("Successfully! Delete a Vehicle Coverage with id = " + id, null, null, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Vehicle Coverage " + "with id = " + id, null, null, null, null, null, null, null, ""),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
}
