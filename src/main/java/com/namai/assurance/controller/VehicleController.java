package com.namai.assurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.namai.assurance.model.Policy;
import com.namai.assurance.model.Message;
import com.namai.assurance.model.Vehicle;
import com.namai.assurance.service.VehicleServices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

	@Autowired
	VehicleServices vehicleServices;

	@PostMapping("/create/{id}")
	public ResponseEntity<Message> addNewVehicle(@RequestBody Vehicle vehicle, @PathVariable long id) {
		try {
			Policy p = vehicleServices.getPolicyServices().getPolicyById(id).get();
			vehicle.setPolicy(p);
			Vehicle returnedVehicle = vehicleServices.saveVehicle(vehicle);

			return new ResponseEntity<Message>(new Message("Upload Successfully!", null, null, null, null, Arrays.asList(returnedVehicle), null, null, null, null, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Vehicle!", null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrieveVehicleInfo() {

		try {
			List<Vehicle> paymentDetailInfos = vehicleServices.getVehicleInfos();

			return new ResponseEntity<Message>(new Message("Get Vehicle's Infos!", null, null, null, null, paymentDetailInfos, null, null, null, null, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getVehicleById(@PathVariable long id) {
		try {
			Optional<Vehicle> optVehicle = vehicleServices.getVehicleById(id);

			if (optVehicle.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a Vehicle by id = " + id, null, null, null, Arrays.asList(optVehicle.get()), null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a Vehicle by id = " + id, null, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updateVehicleById(@RequestBody Vehicle _vehicle, @PathVariable long id) {
		try {
			if (vehicleServices.checkExistedVehicle(id)) {
				Vehicle vehicle = vehicleServices.getVehicleById(id).get();

				// set new values for Vehicle
				vehicle.setYear(_vehicle.getYear());
				vehicle.setMake(_vehicle.getMake());
				vehicle.setModel(_vehicle.getModel());
				vehicle.setColor(_vehicle.getColor());
				vehicle.setTrim(_vehicle.getTrim());
				vehicle.setMileAge(_vehicle.getMileAge());
				vehicle.setVinNumber(_vehicle.getVinNumber());
				vehicle.setVehicleNumberPlate(_vehicle.getVehicleNumberPlate());
				vehicle.setVehicleRegisteredState(_vehicle.getVehicleRegisteredState());
				vehicle.setCreatedDate(_vehicle.getCreatedDate());
				vehicle.setActive(_vehicle.getActive());

				// save the change to database
				vehicleServices.updateVehicle(vehicle);

				return new ResponseEntity<Message>(
						new Message("Successfully! Updated a Vehicle " + "with id = " + id, null, null, null, Arrays.asList(vehicle), null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Vehicle " + "with id = " + id, null, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deleteVehicleById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if (vehicleServices.checkExistedVehicle(id)) {
				vehicleServices.deleteVehicleById(id);

				return new ResponseEntity<Message>(
						new Message("Successfully! Delete a Vehicle with id = " + id, null, null, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Vehicle " + "with id = " + id, null, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} 
	}
