package com.cap.sprint.hbms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.entities.Transactions;
import com.cap.sprint.hbms.services.TransactionsServicesImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/v1")
@Api(value = "Transactions", tags = { "TransactionsAPI" })
public class TransactionsController 
{
	TransactionsServicesImpl  transactionsServicesImpl;
	/**
	 * This method is for adding a Room Details
	 * 
	 * @param RoomDetails
	 * @return RoomDetails
	 * @throws NotFoundException
	 * @throws ValidationException
	 */

	@PostMapping("/transaction")
//	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@ApiOperation(value = "Transaction Details of Payment", notes = "Transaction Details ", response = Transactions.class)
	public ResponseEntity<Transactions> addTransaction(@ApiParam(value = "Transaction details of Payment done", required = true)@RequestBody Transactions transactions)
	{
		Transactions T = transactionsServicesImpl.addTransaction(transactions);
		return new ResponseEntity<Transactions>(T, HttpStatus.CREATED);
	}
}
