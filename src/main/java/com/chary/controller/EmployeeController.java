package com.chary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chary.dto.EmployeeDto;
import com.chary.model.Employee;
import com.chary.service.EmployeeService;


@RestController
@RequestMapping("v1-employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Employee>> getEmployeeDetails(){
		List<Employee> employeeList = employeeService.getEmployeeDetails();
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee){
		employeeService.createEmployee(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/create-employees")
	public ResponseEntity<Void> createEmployees(@RequestBody List<Employee> employees){
		employeeService.createEmployees(employees);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value="/search-employee")
	public ResponseEntity<Employee> getEmployeeDetail(@RequestParam long id){
		Employee employee = employeeService.employeeDetail(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable(name ="id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employee) {
		return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
	}

}
