package com.mohamed.springdemo.service;

import java.util.List;

import com.mohamed.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> CustomerList();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String searchCustomer);
}
