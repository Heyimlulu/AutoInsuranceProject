package com.insurance.assurance.controller;

import com.insurance.assurance.service.PaymentDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.insurance.assurance.model.Bill;
import com.insurance.assurance.model.Message;
import com.insurance.assurance.model.PaymentDetail;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paymentdetail")
public class PaymentDetailController {

	@Autowired
    PaymentDetailServices paymentDetailServices;

	@PostMapping("/create/{id}")
	public ResponseEntity<Message> addNewPaymentDetail(@RequestBody PaymentDetail paymentDetail, @PathVariable long id) {
		try {
			Bill b = paymentDetailServices.getBillServices().getBillById(id).get();
			paymentDetail.setBill(b);
			PaymentDetail returnedPaymentDetail = paymentDetailServices.savePaymentDetail(paymentDetail);

			return new ResponseEntity<Message>(new Message("Upload Successfully!",  null, null, null, Arrays.asList(returnedPaymentDetail), null, null, null, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new Payment Detail!", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrievePaymentDetailInfo() {

		try {
			List<PaymentDetail> paymentDetailInfos = paymentDetailServices.getPaymentDetailInfos();

			return new ResponseEntity<Message>(new Message("Get Payment Detail's Infos!", null, null, null, paymentDetailInfos, null, null, null, ""), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getPaymentDetailById(@PathVariable long id) {
		try {
			Optional<PaymentDetail> optPaymentDetail = paymentDetailServices.getPaymentDetailById(id);

			if (optPaymentDetail.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a Payment Detail by id = " + id, null, null, null, Arrays.asList(optPaymentDetail.get()), null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a Payment Detail by id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updateBillById(@RequestBody PaymentDetail _paymentDetail, @PathVariable long id) {
		try {
			if (paymentDetailServices.checkExistedPaymentDetail(id)) {
				PaymentDetail paymentDetail = paymentDetailServices.getPaymentDetailById(id).get();

				// set new values for Payment Detail
				paymentDetail.setPaidDate(_paymentDetail.getPaidDate());
				paymentDetail.setAmount(_paymentDetail.getAmount());
				paymentDetail.setPaymentMethod(_paymentDetail.getPaymentMethod());
				paymentDetail.setPayerFirstName(_paymentDetail.getPayerFirstName());
				paymentDetail.setPayerLastName(_paymentDetail.getPayerLastName());
				
				paymentDetail.setCardNumber(_paymentDetail.getCardNumber());
				paymentDetail.setZipCode(_paymentDetail.getZipCode());
				paymentDetail.setCardExpireDate(_paymentDetail.getCardExpireDate());
				paymentDetail.setCardType(_paymentDetail.getCardType());
				paymentDetail.setDebitOrCredit(_paymentDetail.getDebitOrCredit());
				
				paymentDetail.setBankName(_paymentDetail.getBankName());
				paymentDetail.setAccountNumber(_paymentDetail.getAccountNumber());
				paymentDetail.setRoutingNumber(_paymentDetail.getRoutingNumber());
				paymentDetail.setCheckNumber(_paymentDetail.getCheckNumber());
				
				paymentDetail.setAdditionalInfos(_paymentDetail.getAdditionalInfos());
				paymentDetail.setCreatedDate(_paymentDetail.getCreatedDate());

				// save the change to database
				paymentDetailServices.updatePaymentDetail(paymentDetail);

				return new ResponseEntity<Message>(
						new Message("Successfully! Updated a Payment Detail " + "with id = " + id, null, null, Arrays.asList(paymentDetail), null, null, null, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Payment Detail " + "with id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deletePaymentDetailById(@PathVariable long id) {
		try {
			// checking the existed of a Policy with id
			if (paymentDetailServices.checkExistedPaymentDetail(id)) {
				paymentDetailServices.deletePaymentDetailById(id);

				return new ResponseEntity<Message>(
						new Message("Successfully! Delete a Payment Detail with id = " + id, null, null, null, null, null, null, ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message("Failer! Can NOT Found a Payment Detail " + "with id = " + id, null, null, null, null, null, null, ""), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message("Failure", null, null, null, null, null, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
