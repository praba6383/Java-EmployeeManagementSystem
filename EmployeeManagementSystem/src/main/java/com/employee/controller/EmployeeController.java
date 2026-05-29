package com.employee.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.entity.ErrorRespons;
import com.employee.service.EmployeeServices;

import jakarta.persistence.criteria.LocalDateTimeField;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeServices service;

	public EmployeeController(EmployeeServices service) {
		this.service = service;
	}

	// CREATE
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	// READ ALL
	@GetMapping
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	// READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id) {
		
			Employee emp = service.getEmployeeById(id);
			return new ResponseEntity<>(emp, HttpStatus.OK);
	
	
	}
	
	/*
	 * @ExceptionHandler(NoSuchElementException.class) public
	 * ResponseEntity<ErrorRespons> NoSuchElementException() { ErrorRespons er=new
	 * ErrorRespons(LocalDateTime.now(), "Employee not found",
	 * "Employee not found in our db"); return new ResponseEntity<>(er,
	 * HttpStatus.BAD_REQUEST); }
	 */
	// UPDATE
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return ResponseEntity.ok("Employee with ID " + id + " deleted successfully");
	}
	


}
