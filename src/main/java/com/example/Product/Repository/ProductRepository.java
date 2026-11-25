package com.example.Product.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Product.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// using fields
	Optional<Product> findByName(String name);
	List<Product> findByPrice(Double price);
	
	// using combining fields
	List<Product> findByNameAndPrice(String name, Double price);
	
	// using operators
	List<Product> findByPriceGreaterThan(Double price);
	List<Product> findByNameContaining(String name);
}
