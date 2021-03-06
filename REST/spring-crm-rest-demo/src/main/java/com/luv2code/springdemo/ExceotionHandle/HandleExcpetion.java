package com.luv2code.springdemo.ExceotionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExcpetion {

	@ExceptionHandler
	public  ResponseEntity<ExceptionErrorMessage> handleError(ThrowCustomerExcpetion exc) {
		ExceptionErrorMessage error = new ExceptionErrorMessage();
		
		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public  ResponseEntity<ExceptionErrorMessage> handleError(Exception exc) {
		ExceptionErrorMessage error = new ExceptionErrorMessage();
		
		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
