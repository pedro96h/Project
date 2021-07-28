package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/products")
@Api(value = "API REST Products")
@CrossOrigin(origins = "*")
public class ProductResource {

	@Autowired
	private ProductService ProductService;

	@GetMapping
	@ApiOperation(value = "List all products")
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = ProductService.findAll();
		if (list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get Product by id")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		var objClient = ProductService.findById(id);
		return ResponseEntity.ok().body(objClient);
	}

	@PostMapping
	@ApiOperation(value = "Insert a new product in database")
	public ResponseEntity<Product> insert(@RequestBody Product obj) {
		obj = ProductService.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Delete a product by id")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ProductService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@ApiOperation(value = "update a product")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj) {
		obj = ProductService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
