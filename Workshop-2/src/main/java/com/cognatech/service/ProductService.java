package com.cognatech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognatech.entity.Product;
import com.cognatech.repository.ProductRepository;

@Service
public class ProductService {

	ProductRepository productRepository;
	
	ProductService(ProductRepository productRepo) {
		this.productRepository = productRepo;
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public String addProduct(Product product) {
		productRepository.save(product);
		return "Product added successfully";
	}
	
	public String updateProduct(int id, Product product) {
		if(productRepository.existsById(id)) {
			product.setId(id);
			productRepository.save(product);
			
//			Product existingProduct = productRepository.findById(id).get();
//			existingProduct.setPrice(product.getPrice());
//			existingProduct.setQuantity(product.getQuantity());
//			existingProduct.setDescription(product.getDescription());
//			productRepository.save(existingProduct);
			
			return "Product updated successfully";
		} else {
			return "Product with id " + id + " not found.";
		}
	}
	
	public String deleteProduct(int id) {
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return "Product deleted successfully";
		} else {
			return "Product with id " + id + " not found.";
		}
	}
}
