package com.appcom.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exception.MyException;
import com.app.pojos.Student;
import com.app.repository.StudentRepository;

@Service
@Transactional

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository stud;

	@Override
	public Student addStudent(Student stu) {
		// TODO Auto-generated method stub
		return stud.save(stu);
		
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return stud.findAll();
	}

	@Override
	public Student getById(Long id) {
		// TODO Auto-generated method stub
		//return stud.findById(id).orElseThrow(()->new MyException("student not found"));
	return stud.findById(id).orElseThrow(()->new MyException("djdj"));
	}

	@Override
	public String delById(Long id) {
		// TODO Auto-generated method stub
		if(stud.existsById(id)) {
			stud.deleteById(id);
			return "stud deleted";
		}
		return "stud not found";
	}


}
