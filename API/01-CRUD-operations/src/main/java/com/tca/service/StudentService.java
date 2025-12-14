package com.tca.service;

import java.util.List;

import com.tca.entities.Student;

public interface StudentService {

	public abstract List<Student> fetchStudents();
	
	public abstract boolean saveStudent(Student student);
	
	public abstract boolean removeStudent(Integer rno);
	
	public abstract boolean updateStudent(Student student);

	public abstract Student fetchStudent(Integer rno);
}
