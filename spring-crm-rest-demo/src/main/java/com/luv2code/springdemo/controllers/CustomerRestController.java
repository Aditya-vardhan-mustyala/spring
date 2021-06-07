package com.luv2code.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.rest.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/crm")
public class CustomerRestController 
{
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	public List<Customer> getall()
	{
		return service.getCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getone(@PathVariable int id)
	{
		Customer customer=service.getCustomer(id);
		if(customer==null)
			throw new CustomerNotFoundException("customer with id "+id+" is not found");
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer setone(@RequestBody Customer customer)
	{
		customer.setId(0);
		service.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateone(@RequestBody Customer customer)
	{
		service.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("/customers/{id}")
	public String deleteone(@PathVariable int id)
	{
		Customer customer=service.getCustomer(id);
		if(customer==null)
			throw new CustomerNotFoundException("customer with id "+id+" is not found");
		service.deleteCustomer(id);
		//return customer;
		return "Deleted customer with id "+id;
	}
	
}
