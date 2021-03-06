package com.mohamed.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed.springdemo.dao.CustomerDAO;
import com.mohamed.springdemo.entity.Customer;

@Service // handle all DAO at Service Layer
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional // handle set, Get and Commit Session.
	public List<Customer> CustomerList() {
		return customerDAO.getCustomerList();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String searchCustomer) {
		return customerDAO.searchCustomer(searchCustomer);
	}

}

