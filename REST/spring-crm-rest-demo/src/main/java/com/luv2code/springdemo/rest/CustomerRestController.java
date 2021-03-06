package com.luv2code.springdemo.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.ExceotionHandle.ThrowCustomerExcpetion;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	// get all customers
	@GetMapping("/customers")
	public List<Customer> getListCustomers() {
		return customerService.getCustomers();
	}
	
	// get single customer
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer == null) {
			throw new ThrowCustomerExcpetion("unable to find customer " + customerId);
		}
		
		return theCustomer;
	}
	
	// add/insert customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// initialize Id of Customer to 0 or null to insert new Customer
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	} 
	
	// update a customer
	@PutMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	// delete a customer
	@DeleteMapping("/customers/{cutsomerId}")
	public String deleteCustomer(@PathVariable int cutsomerId) {
		
		Customer theCustomer = customerService.getCustomer(cutsomerId);
		
		// throw an exception if customer is not found
		if(theCustomer == null) {
			throw new ThrowCustomerExcpetion("unable to find customer " + cutsomerId);
		}
	
		customerService.deleteCustomer(cutsomerId);
		
		return "Deleted Customer id- " + cutsomerId;
	}
	
}

