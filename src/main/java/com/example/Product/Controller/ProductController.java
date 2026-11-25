package com.example.Product.Controller;
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

import com.example.Product.Entity.Product;
import com.example.Product.Service.ProductService;

@RestController
@RequestMapping("/x")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/createproduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		return ResponseEntity.ok(productService.createProduct(product));
		
	}
	
	@GetMapping("/getproduct/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		return ResponseEntity.ok(productService.getProduct(id));
	}
	
	@PutMapping("/updateprodct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return ResponseEntity.ok(productService.updateProduct(id, product));
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}
}
