package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Transaction;
import com.example.demo.servicies.TransactionService;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionResource {
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping(value = "/{clientId}")
	public ResponseEntity<Long> getTransactionId(@PathVariable Long clientId) {
		Transaction transaction = transactionService.getTransactionId(clientId);
		return ResponseEntity.ok().body(transaction.getId());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Long> confirTransaction(@PathVariable Long id) {
		boolean response = transactionService.confirTransaction(id);
		if(response) {
			return ResponseEntity.ok().build();	
		}
		return ResponseEntity.noContent().build();
	}
}
