package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Product;
import com.example.demo.entities.Purchase;
import com.example.demo.entities.Transaction;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

}
