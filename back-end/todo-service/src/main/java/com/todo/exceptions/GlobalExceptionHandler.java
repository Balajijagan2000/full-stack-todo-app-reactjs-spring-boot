package com.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global Exception Handler
//Controller Advice is to handle multiple exceptions
@ControllerAdvice
public class GlobalExceptionHandler {

	//Handling BaseException caused by API
	@ExceptionHandler(value= {BaseException.class})
	public ResponseEntity<ExceptionResponse> handleApiException(BaseException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage(e.getMessage());
		return new ResponseEntity<>(response,response.getStatus());
	}
	
	//Handling other exceptions
	@ExceptionHandler(value= {Exception.class,RuntimeException.class})
	public ResponseEntity<ExceptionResponse> handleException(Exception e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage("Problem with app server");
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
