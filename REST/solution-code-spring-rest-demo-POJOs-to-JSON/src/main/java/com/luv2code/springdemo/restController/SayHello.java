package com.luv2code.springdemo.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.student.Student;

@RestController
@RequestMapping("/hello")
public class SayHello {
	
	private List<Student> studentList;
	
	@GetMapping("/student")
	public List<Student> sayHelloRest() {
		
		studentList = new ArrayList<>();
		
		studentList.add(new Student("mohamed", "ahmed"));
		studentList.add(new Student("malak", "saeed"));
		studentList.add(new Student("mostafa", "ahmed"));

		
		return studentList;
	}

}
