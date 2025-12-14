package com.tca.service;

import java.util.List;

import com.tca.entities.Student;
import com.tca.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService{
	
	@Override
	public List<Student> fetchStudents() {
		return StudentDaoFactory.getStudentDaoInstance().getStudents();
	}

	@Override
	public boolean saveStudent(Student student) {
		return StudentDaoFactory.getStudentDaoInstance().addStudent(student);
	}

	@Override
	public boolean removeStudent(Integer rno) {
		Student student = StudentDaoFactory.getStudentDaoInstance().getStudent(rno);
		if(student == null)
			return false;
		return StudentDaoFactory.getStudentDaoInstance().deleteStudent(student);
	}

	@Override
	public Student fetchStudent(Integer rno) {
		return StudentDaoFactory.getStudentDaoInstance().getStudent(rno);
	}

	@Override
	public boolean updateStudent(Student student) {
		return StudentDaoFactory.getStudentDaoInstance().updateStudent(student);
	}

}
