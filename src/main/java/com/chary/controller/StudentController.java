package com.chary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.model.Student;
import com.chary.service.StudentService;

@RestController
@RequestMapping("/v1-student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Student>> getStudentDetails(){
		List<Student> students = studentService.getStudentDetails();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

}
