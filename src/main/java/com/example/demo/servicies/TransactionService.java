package com.example.demo.servicies;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.enums.TrasactionStatus;
import com.example.demo.exceptions.entities.ResourceNotFoundException;
import com.example.demo.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ClientService clientService;

	public Transaction getTransactionId(Long ClientId) {
		clientService.findById(ClientId);
		var transaction = transactionRepository
				.save(new Transaction(LocalDateTime.now(), ClientId, TrasactionStatus.PENDING));
		return transaction;
	}

	public void confirTransaction(Long id) {
		var optTransaction = transactionRepository.findById(id);
		if (optTransaction.isEmpty()) {
			throw new ResourceNotFoundException("Transaction not found");
		} else {
			var transaction = optTransaction.get();
			transaction.setTransactionStatus(TrasactionStatus.COMPLETE);
			transactionRepository.save(transaction);
		}

	}

	public Transaction findById(long transactionID) {
		var optTransaction = transactionRepository.findById(transactionID);
		if (optTransaction.isEmpty()) {
			throw new ResourceNotFoundException(transactionID);
		}
		return optTransaction.get();
	}

}
