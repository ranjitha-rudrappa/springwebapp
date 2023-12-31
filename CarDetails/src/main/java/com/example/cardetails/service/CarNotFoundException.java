package com.example.cardetails.service;

public class CarNotFoundException extends RuntimeException {
 

	public CarNotFoundException(String message) {
		super(message);
	}
	public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
