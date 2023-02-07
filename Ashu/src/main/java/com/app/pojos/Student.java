package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="student")
public class Student extends BaseEntity {
	
	private String name;
	@Column(unique=true)
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length=30)
	private String password;
	
	@OneToMany(mappedBy ="student" ,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Course> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addCourse(Course c) {
		courses.add(c);
		c.setStudent(this);
		
	}
	
	
}
