package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.entities.enums.TrasactionStatus;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime data;
	private long clientId;
	private TrasactionStatus transactionStatus;

	public Transaction() {
	}

	public Transaction(LocalDateTime data, long clientId, TrasactionStatus transactionStatus) {
		this.data = data;
		this.clientId = clientId;
		this.transactionStatus = transactionStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public TrasactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TrasactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

}
