package com.example.Product.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.Product.Entity.ErrorResponse;

//handle exceptions globally across all controllers
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// It defines a method that gets executed when a particular exception occurs, allowing you to customize the error response.
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> productNotFoundExceptionHandler(ProductNotFoundException pnfex, WebRequest webRequest) {
		
		ErrorResponse errorResponse = new ErrorResponse(
				LocalDateTime.now(),
				pnfex.getMessage(),
				webRequest.getDescription(false),  
				"PRODUCT_NOT_FOUND");
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);		
		
	}
	

	@ExceptionHandler(DuplicateProductException.class)
	public ResponseEntity<ErrorResponse> duplicateProductExceptionHandler(DuplicateProductException dpex,
			WebRequest webRequest) {
		
		ErrorResponse errorResponse = new ErrorResponse(
				LocalDateTime.now(), 
				dpex.getMessage(),
				webRequest.getDescription(false), 
				"DUPLICATE PRODUCT FOUND");
		
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		
		
	}
}
