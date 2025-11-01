package com.cognatech.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognatech.entity.Product;
import com.cognatech.service.ProductService;

@RestController
public class ProductController {
	
	ProductService productService;
	
	ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/products")
	@PreAuthorize("hasRole('ADMIN')")
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
		return productService.updateProduct(id, updatedProduct);
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) { //@RequestParam String name
		return productService.deleteProduct(id);
	}
	
}
