package com.luv2code.springdemo.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luv2code.springdemo.rest.CustomerErrorResponse;
import com.luv2code.springdemo.rest.CustomerNotFoundException;

@ControllerAdvice
public class RestExceptionHandler
{
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handler(CustomerNotFoundException ex)
	{
		CustomerErrorResponse err=new CustomerErrorResponse();
		
		err.setMessage(ex.getMessage());
		err.setTime(System.currentTimeMillis());
		err.setStatus(404);
		
		return new ResponseEntity<CustomerErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handlerAll(Exception ex)
	{
		CustomerErrorResponse err=new CustomerErrorResponse();
		
		err.setMessage(ex.getMessage());
		err.setTime(System.currentTimeMillis());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<CustomerErrorResponse>(err,HttpStatus.BAD_REQUEST);
	}

}
