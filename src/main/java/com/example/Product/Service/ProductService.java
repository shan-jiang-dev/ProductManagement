package com.example.Product.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product.Entity.Product;
import com.example.Product.Exception.DuplicateProductException;
import com.example.Product.Exception.ProductNotFoundException;
import com.example.Product.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		
		if(productRepository.findByName(product.getName()).isPresent()) {
			throw new DuplicateProductException("Product by the name " + product.getName() + "is already exist");
		}
		
		return productRepository.save(product);
		
	}
	
	public Product getProduct(Long id) {
		
		return productRepository.findById(id).orElseThrow(
				() -> new ProductNotFoundException("Product with id " + id + " is not found")
				);
	}
	
	public Product updateProduct(Long id, Product product) {
		
		Product existingProduct = getProduct(id);
		
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		
		return productRepository.save(existingProduct);
		
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
