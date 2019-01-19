package com.java.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handler code here
	
	//Add an exception handler the exception - @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
		}
		
		//add an exception to handle any exception-generic exception
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
			
		}

	
}
