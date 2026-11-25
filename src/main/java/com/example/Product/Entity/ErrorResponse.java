package com.example.Product.Entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // 它会自动生成一个包含所有 fields 的 Constructor。
@Data // 它会自动生成：- Getters - Setters - toString() - equals() - hashCode()
public class ErrorResponse {

	LocalDateTime timeStamp;
	String errorMessage;
	String errorDetails;
	String errorCode;
}
