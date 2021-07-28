package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.servicies.ProductService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource {

	@Autowired
	private ProductService ProductService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = ProductService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		var objClient = ProductService.findById(id);
		if (objClient != null) {
			return ResponseEntity.ok().body(objClient);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product obj) {
		obj = ProductService.insert(obj);
		if (obj == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(obj);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ProductService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj) {
		obj = ProductService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
