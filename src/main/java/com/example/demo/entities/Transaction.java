package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.resource.transaction.spi.TransactionStatus;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime data;
	@ForeignKey(name = "Client")
	private long clientId;
	private TransactionStatus transactionStatus;
	@Transient
	private Set<Purchase> purchases = new HashSet<>();
}
