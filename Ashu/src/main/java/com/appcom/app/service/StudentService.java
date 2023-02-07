package com.appcom.app.service;

import java.util.List;

import com.app.pojos.Student;

public interface StudentService {

Student addStudent(Student stu);
List<Student> getAllStudents();
Student getById(Long id);
String delById(Long id);

}
