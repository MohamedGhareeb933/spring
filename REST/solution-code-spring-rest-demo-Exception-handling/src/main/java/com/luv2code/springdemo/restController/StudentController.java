package com.luv2code.springdemo.restController;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.student.Student;
import com.luv2code.springdemo.studentException.StudentErrorResponse;
import com.luv2code.springdemo.studentException.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private List<Student> studentList;
	
	// @postConstruct is loaded only once the given bean is constructed
	@PostConstruct
	public void loadStudentList() {
		
		studentList = new ArrayList<>();
		
		studentList.add(new Student("mohamed", "ahmed"));
		studentList.add(new Student("malak", "saeed"));
		studentList.add(new Student("mostafa", "ahmed"));
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		
		if(studentId >= studentList.size() || studentId < 0) {
			throw new StudentNotFoundException("Student not found - " + studentId);
		}
		return studentList.get(studentId);
	}
	
	@GetMapping("/students")
	public List<Student> getStudentById() {	
		return studentList;
	}
	
}
