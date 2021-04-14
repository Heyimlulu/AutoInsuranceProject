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
import com.namai.assurance.service.PolicyServices;

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
			
			return new ResponseEntity<Message>(new Message("Upload Successfully!", 
											Arrays.asList(returnedDriver), null), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Policy!", 
											null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrievePolicyInfo() {
		
		try {
			List<Driver> driverInfos = driverServices.getDriverInfos();
			
			return new ResponseEntity<Message>(new Message("Get Policys' Infos!", 
												driverInfos, null), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!",
												null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getPolicyById(@PathVariable long id) {
		try {
			Optional<Driver> optDriver = driverServices.getPolicyById(id);
			
			if(optDriver.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a policy by id = " + id,
															Arrays.asList(optDriver.get()), null), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a policy by id = " + id,
						null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updateDriverById(@RequestBody Driver _driver, 
																	@PathVariable long id) {
		try {
			if(driverServices.checkExistedDriver(id)) {
				Driver driver = driverServices.getPolicyById(id).get();
				
				//set new values for policy
				driver.setTitle(_driver.getTitle());
				driver.setFirstName(_driver.getFirstName());
				driver.setLastName(_driver.getLastName());
				driver.setMiddleInitial(_driver.getMiddleInitial());
				driver.setDoB(driver.getDoB());
				driver.setEmail(driver.getEmail());
				driver.setPhoneNumber(driver.getPhoneNumber());
				driver.setCellNumber(driver.getCellNumber());
				driver.setSSN(driver.getSSN());
				driver.setLicenseIssuedDate(driver.getLicenseIssuedDate());
				driver.setLicenseNumber(driver.getLicenseNumber());
				driver.setIsPrimaryPolicyHolder(driver.getIsPrimaryPolicyHolder());
				driver.setRelationWithPrimaryPolicyHolder(driver.getRelationWithPrimaryPolicyHolder());
				driver.setMaritalStatuts(driver.getMaritalStatuts());
				driver.setGender(driver.getGender());
				driver.setActive(driver.getActive());
	
				// save the change to database
				driverServices.updateDriver(driver);
				
				return new ResponseEntity<Message>(new Message("Successfully! Updated a Policy "
																		+ "with id = " + id,
																	Arrays.asList(driver), null), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Policy "
						+ "with id = " + id,
					null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deleteDriverById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if(driverServices.checkExistedDriver(id)) {
				driverServices.deleteDriverById(id);
				
				return new ResponseEntity<Message> (new Message("Successfully! Delete a Policy with id = " + id, 
														null, ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Policy "
														+ "with id = " + id, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
