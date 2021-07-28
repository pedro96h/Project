package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Transaction;
import com.example.demo.servicies.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/transaction")
@Api(value = "API REST Transaction")
@CrossOrigin(origins = "*")
public class TransactionResource {

	@Autowired
	private TransactionService transactionService;

	@GetMapping(value = "/getTransactionId/{clientId}")
	@ApiOperation(value = "returns a transaction id")
	public ResponseEntity<Long> getTransactionId(@PathVariable Long clientId) {
		Transaction transaction = transactionService.getTransactionId(clientId);
		return ResponseEntity.ok().body(transaction.getId());
	}

	@GetMapping(value = "/confirTransaction/{id}")
	@ApiOperation(value = "confirm de transaction on database")
	public ResponseEntity<Long> confirTransaction(@PathVariable Long id) {
		transactionService.confirTransaction(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/totalvalue/{id}")
	@ApiOperation(value = "get total value of transaction")
	public ResponseEntity<Double> getTotalvalue(@PathVariable Long id) {
		var total =transactionService.getTotalvalue(id);
		return ResponseEntity.ok().body((Double)total);
	}
}
