package com.java.springrestdemo.rest;

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

import com.java.springrestdemo.bo.Students;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Students> student;
	
	// define @PostConstruct to load student data only once
	//The PostConstruct annotation is used on a method that needs to be executed after dependency injection is done 
	//to perform any initialization.
	@PostConstruct
	public void loadData() {
		student = new ArrayList<>();
        student.add(new Students("Saurabh", "Patel"));
        student.add(new Students("Raghvendra", "Singh"));
        student.add(new Students("Shailesh", "Bopche"));
	}

	
	//define end points for /students
	@GetMapping("/students")
	public List<Students> getStudents(){
		return student;
	}
	
	//define end points for /students/{studentId} - return students at index
	@GetMapping("/students/{studentId}")
	public Students getStudents(@PathVariable int studentId) {	
		
		if(studentId>=student.size() || studentId<0) {
			throw new StudentNotFoundException("Student id not found "+ studentId);
		}
		return student.get(studentId);
	}
	
}
