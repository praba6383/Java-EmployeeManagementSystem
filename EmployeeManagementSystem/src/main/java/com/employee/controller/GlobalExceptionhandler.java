package com.employee.controller;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.entity.ErrorRespons;
@ControllerAdvice
public class GlobalExceptionhandler {
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorRespons> NoSuchElementException() {
		ErrorRespons er=new ErrorRespons(LocalDateTime.now(), "Employee not register", "Employee not found in our db");
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	}


}
