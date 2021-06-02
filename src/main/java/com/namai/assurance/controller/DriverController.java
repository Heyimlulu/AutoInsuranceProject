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
import com.namai.assurance.model.Driver;
import com.namai.assurance.model.Message;
import com.namai.assurance.service.DriverServices;

@RestController
@RequestMapping("/api/driver")
public class DriverController {
	
	@Autowired
	DriverServices driverServices;
	
	@PostMapping("/create/{id}")
	public ResponseEntity<Message> addNewPolicy(@RequestBody Driver driver, @PathVariable long id) {
		try {
			Policy p = driverServices.getPolicyServices().getPolicyById(id).get();
			driver.setPolicy(p);
			Driver returnedDriver = driverServices.saveDriver(driver);
			
			return new ResponseEntity<Message>(new Message("Upload Successfully!",  null,null, null, null, null, Arrays.asList(returnedDriver), null, ""), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Driver!", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrievePolicyInfo() {
		
		try {
			List<Driver> driverInfos = driverServices.getDriverInfos();
			
			return new ResponseEntity<Message>(new Message("Get Driver Infos!", null, null, null, null, null, driverInfos, null, null), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getPolicyById(@PathVariable long id) {
		try {
			Optional<Driver> optDriver = driverServices.getPolicyById(id);
			
			if(optDriver.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a driver by id = " + id, null, null, null, null, null, Arrays.asList(optDriver.get()), null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a driver by id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updateDriverById(@RequestBody Driver _driver, @PathVariable long id) {
		try {
			if(driverServices.checkExistedDriver(id)) {
				Driver driver = driverServices.getPolicyById(id).get();
				
				//set new values for driver
				driver.setTitle(_driver.getTitle());
				driver.setFirst_name(_driver.getFirst_name());
				driver.setLast_name(_driver.getLast_name());
				driver.setMiddleInitial(_driver.getMiddleInitial());
				driver.setDob(_driver.getDob());
				driver.setEmail_adress(_driver.getEmail_adress());
				driver.setPhone_number(_driver.getPhone_number());
				driver.setCellNumber(_driver.getCellNumber());
				driver.setSsn(_driver.getSsn());
				driver.setLicense_issue_date(_driver.getLicense_issue_date());
				driver.setLicense_issue_state(_driver.getLicense_issue_state());
				driver.setLicense_number(_driver.getLicense_number());
				driver.setIs_primary_policy_holder(_driver.getIs_primary_policy_holder());
				driver.setRelation_withPrimary_policy_holder(_driver.getRelation_withPrimary_policy_holder());
				driver.setMarital_statut(_driver.getMarital_statut());
				driver.setGender(_driver.getGender());
				driver.setActive(_driver.getActive());
	
				// save the change to database
				driverServices.updateDriver(driver);
				
				return new ResponseEntity<Message>(new Message("Successfully! Updated a Driver " + "with id = " + id, null, null, null, null, Arrays.asList(driver), null, ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Driver " + "with id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deleteDriverById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if(driverServices.checkExistedDriver(id)) {
				driverServices.deleteDriverById(id);
				
				return new ResponseEntity<Message> (new Message("Successfully! Delete a Driver with id = " + id, null, null, null, null, null, null, ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Driver " + "with id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
