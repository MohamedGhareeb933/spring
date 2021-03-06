package com.example.springboot.thymeleafdemo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.thymeleafdemo.dao.EmployeeDao;
import com.example.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceDao implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getEmployeeList() {	
		return employeeDao.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee getSingleEmployee(int id) {
		
		Optional<Employee> employee = employeeDao.findById(id);
		
		if(employee.isEmpty()) {
			throw new RuntimeException("employee with ID " + id + "is not found");
		}
		return employee.get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		Employee dbEmployee = employeeDao.save(employee);
		
		employee.setId(dbEmployee.getId());
		
		return dbEmployee;
	}

	@Override
	public String deleteEmployee(int id) {
		
		Optional<Employee> employee  = employeeDao.findById(id);
		
		if (employee.isEmpty()) {
			throw new RuntimeException("employee with ID: " + id + "is not found");
		}
		
		employeeDao.deleteById(id);
		return "Employee with id: " + id + "is deleted";
	}

}
