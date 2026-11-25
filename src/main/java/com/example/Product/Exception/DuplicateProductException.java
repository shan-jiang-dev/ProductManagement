package com.example.Product.Exception;

public class DuplicateProductException extends RuntimeException{

	public DuplicateProductException(String message) {
		super(message); // super(m) will call the parent method
	}
}
