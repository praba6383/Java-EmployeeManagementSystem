package com.employee.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.controller.EmployeeNotFonndException;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
@Service
public class EmployeeServices {
	private final EmployeeRepository repository;

    public  EmployeeServices(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow() ;
    }

    public Employee updateEmployee(Long id, Employee emp) {
        Employee existing = getEmployeeById(id);
        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setDepartment(emp.getDepartment());
        return repository.save(existing);
    }

    public void deleteEmployee(Long id) {
    	if (!repository.existsById(id)) {
            throw new NoSuchElementException("Employee not found with id: " + id);
        }
        repository.deleteById(id);
    }


}
