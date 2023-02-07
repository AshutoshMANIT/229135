package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Student;
import com.appcom.app.service.StudentService;

@RestController
@RequestMapping("/student")

public class StudentController {
	@Autowired
	private StudentService ser;
	@GetMapping("/paao")
	public List<Student> getAllStudent(){
		
		return ser.getAllStudents();
	}
	@PostMapping("/add")
public Student addStudent(@RequestBody Student stu) {
		
		return ser.addStudent(stu);
		
	}
	@GetMapping("/id")
	public Student getById(@RequestBody Long id) {
		return ser.getById(id);
	}

	@DeleteMapping("/del")
	public String delById(@RequestBody Long id) {
		ser.delById(id);
		return "student deleted";
	}

}
