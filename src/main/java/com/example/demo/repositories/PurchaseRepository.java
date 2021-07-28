package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	List<Purchase> findByTransactionID(Long id);
	
}
