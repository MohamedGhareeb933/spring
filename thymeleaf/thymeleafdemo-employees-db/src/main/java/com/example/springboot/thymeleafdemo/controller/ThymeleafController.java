package com.example.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class ThymeleafController {
	
	
	private EmployeeService employeeService;
	
	@Autowired
	ThymeleafController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String getEmployee(Model theModel) {
		
		theModel.addAttribute("employees", employeeService.getEmployeeList());
		
		return "list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String addEmployee(Model theModel) {
		
		Employee employee = new Employee();
		
		theModel.addAttribute("theEmployee", employee);
		
		return "employess/save-employee";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId") int id, Model theModel) {
		
		Employee employee = employeeService.getSingleEmployee(id);
		
		theModel.addAttribute("theEmployee", employee);
		
		return "employess/save-employee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee theEmployee) {
		
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete") 
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		
		employeeService.deleteEmployee(id);
		
		return "redirect:/employees/list";
	}
}


