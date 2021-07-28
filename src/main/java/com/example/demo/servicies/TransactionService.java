package com.example.demo.servicies;

import java.time.LocalDateTime;

import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.enums.TrasactionStatus;
import com.example.demo.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction getTransactionId(Long ClientId) {
		var transaction = transactionRepository.save(new Transaction(LocalDateTime.now(),ClientId,TrasactionStatus.PENDING));
		return transaction;
	}

	public boolean confirTransaction(Long id) {
		var transaction = transactionRepository.findById(id).get();
		if(transaction == null) {
			return false;
		}else {
			transaction.setTransactionStatus(TrasactionStatus.COMPLETE);
			transactionRepository.save(transaction);
			return true;
		}
		
	}

}
