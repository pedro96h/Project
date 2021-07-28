package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Purchase;
import com.example.demo.servicies.PurchaseService;

@RestController
@RequestMapping(value = "/api/purchase")
public class PurchaseResource {

	@Autowired
	private PurchaseService purchaseService;

	@PostMapping
	public ResponseEntity<Purchase> insert(@RequestBody Purchase obj) {
		obj = purchaseService.insert(obj);
		if (obj == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(obj);
		}
	}

}
