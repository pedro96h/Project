package com.example.demo.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Purchase;
import com.example.demo.repositories.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
	private ProductService productService; 
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public double getTotalValue(Long productId, int qtd) {
		var product = productService.findById(productId);
		return product.getPrice() * qtd;
	}
	
	public Purchase insert(Purchase obj) {
		return purchaseRepository.save(obj);
	}
}
