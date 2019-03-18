package com.chary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.dao.EmployeeDAO;
import com.chary.dto.EmployeeDto;
import com.chary.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;

	public List<Employee> getEmployeeDetails() {
		
		Iterable<Employee> employees=employeeDao.findAll();
		List<Employee> employeeList = new ArrayList<>();
		employees.forEach(employee -> employeeList.add(employee));		
		return employeeList;
	}
	
	public void createEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	public Employee employeeDetail(long id) {
		Optional<Employee> optionalEmployee = employeeDao.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			return employee;
		} 
		return null;
	}

	public void deleteEmployee(long id) {
		employeeDao.deleteById(id);
	}

	public EmployeeDto updateEmployee(EmployeeDto employee) {
        Optional<Employee> optionalEmployee = employeeDao.findById(employee.getId());
        if (optionalEmployee.isPresent()) {
        	Employee employee2 = toModel(employee);
        	Employee employee1 = employeeDao.save(employee2);
        	EmployeeDto employeeDto = toDto(employee1);
        	return employeeDto;
        }
        return null;
	}

	private Employee toModel(EmployeeDto employee) {
		Employee employee2 = new Employee();
		employee2.setId(employee.getId());
		employee2.setName(employee.getName());
		employee2.setDepartment(employee.getDepartment());
		return employee2;
	}

	private EmployeeDto toDto(Employee employee1) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee1.getId());
		employeeDto.setName(employee1.getName());
		employeeDto.setDepartment(employee1.getDepartment());
		return employeeDto;
	}

	public void createEmployees(List<Employee> employees) {
        employeeDao.saveAll(employees);		
	}

}
