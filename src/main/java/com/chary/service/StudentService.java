package com.chary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.dao.StudentDao;
import com.chary.model.Student;

@Service
public class StudentService {
	
@Autowired
private StudentDao studentDao;

public List<Student> getStudentDetails() {
	Iterable<Student> students = studentDao.findAll();
	List<Student> studentList = new ArrayList<>();
//	for(Student student: students) {
//		studentList.add(student);
//	}
	students.forEach(student -> studentList.add(student));

	return studentList;
}

}
