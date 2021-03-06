package com.example.springboot.thymeleafdemo.service;

import java.util.List;

import com.example.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployeeList();
	
	public Employee getSingleEmployee(int id);
	
	public Employee saveEmployee(Employee employee);
	
	public String deleteEmployee(int id);
}
