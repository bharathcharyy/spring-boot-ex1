package com.chary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chary.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long>{

	

}
