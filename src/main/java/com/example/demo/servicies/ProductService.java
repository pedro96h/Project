package com.example.demo.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.exceptions.entities.ResourceNotFoundException;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		} else {
			throw new ResourceNotFoundException(id);
		}
	}

	public Product insert(Product obj) {
		return productRepository.save(obj);
	}

	public void delete(Long id) {
		var optEntity = productRepository.findById(id);
		if (optEntity.isEmpty()) {
			throw new ResourceNotFoundException(id);
		}
		productRepository.deleteById(id);
	}

	public Product update(Long id, Product obj) {
		var optEntity = productRepository.findById(id);
		if(optEntity.isEmpty()) {
			throw new ResourceNotFoundException(id);
		}
		var entity = optEntity.get();
		updateData(entity, obj);
		return productRepository.save(entity);
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setInventory(obj.getInventory());
		entity.setPrice(obj.getPrice());
	}

}
