package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorMessage> handleException(CustomerNotFoundException ex) {
		
		CustomerErrorMessage error = 
				new CustomerErrorMessage(
						HttpStatus.NOT_FOUND.value(), 
						ex.getMessage(), 
						System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorMessage>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorMessage> handleException(Exception ex) {
		
		CustomerErrorMessage error = 
				new CustomerErrorMessage(
						HttpStatus.BAD_REQUEST.value(), 
						ex.getMessage(), 
						System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorMessage>(error, HttpStatus.BAD_REQUEST);
		
	}

}
