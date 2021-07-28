package com.example.demo.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
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
			return null;
		}
	}

	public Product insert(Product obj) {
		return productRepository.save(obj);
	}

	public void delete(Long id) {
		try {
			Product entity = productRepository.getOne(id);
			productRepository.deleteById(id);;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Product update(Long id, Product obj) {
		try {
			Product entity = productRepository.getOne(id);
			updateData(entity, obj);
			return productRepository.save(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setInventory(obj.getInventory());
		entity.setPrice(obj.getPrice());
	}

}
