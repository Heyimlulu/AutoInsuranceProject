package com.namai.assurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.namai.assurance.model.Policy;
import com.namai.assurance.model.Message;
import com.namai.assurance.model.Bill;
import com.namai.assurance.service.BillServices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	BillServices billServices;

	@PostMapping("/create/{id}")
	public ResponseEntity<Message> addNewBill(@RequestBody Bill bill, @PathVariable long id) {
		try {
			Policy p = billServices.getPolicyServices().getPolicyById(id).get();
			bill.setPolicy(p);
			Bill returnedBill = billServices.saveBill(bill);

			return new ResponseEntity<Message>(new Message("Upload Successfully!", null, null, Arrays.asList(returnedBill), null, null, null, null, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Bill!", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrieveBillInfo() {

		try {
			List<Bill> billInfos = billServices.getBillInfos();

			return new ResponseEntity<Message>(new Message("Get Bill's Infos!",	null, null, billInfos, null, null, null, null, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, null, null, null, null, null, ""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getBillById(@PathVariable long id) {
		try {
			Optional<Bill> optBill = billServices.getBillById(id);

			if (optBill.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a Bill by id = " + id, null, null,  Arrays.asList(optBill.get()), null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a Bill by id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updateBillById(@RequestBody Bill _bill, @PathVariable long id) {
		try {
			if (billServices.checkExistedBill(id)) {
				Bill bill = billServices.getBillById(id).get();

				// set new values for Bill
				bill.setDueDate(_bill.getDueDate());
				bill.setMinimumPayment(_bill.getMinimumPayment());
				bill.setCreatedDate(_bill.getCreatedDate());
				bill.setBalance(_bill.getBalance());
				bill.setStatus(_bill.getStatus());

				// save the change to database
				billServices.updateBill(bill);

				return new ResponseEntity<Message>(
						new Message("Successfully! Updated a Bill " + "with id = " + id, null, Arrays.asList(bill), null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Bill " + "with id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deleteBillById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if (billServices.checkExistedBill(id)) {
				billServices.deleteBillById(id);

				return new ResponseEntity<Message>(
						new Message("Successfully! Delete a Bill with id = " + id, null, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Bill " + "with id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
