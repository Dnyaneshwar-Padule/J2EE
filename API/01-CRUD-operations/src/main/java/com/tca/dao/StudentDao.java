package com.tca.dao;

import java.util.List;

import com.tca.entities.Student;

public interface StudentDao {

	public abstract List<Student> getStudents();
	
	public abstract boolean addStudent(Student student);
	
	public abstract boolean deleteStudent(Student student);

	public abstract Student getStudent(Integer rno);
	
	public abstract boolean updateStudent(Student student);
}
