package com.tca.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tca.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private static final Map<Integer, Student> students = new HashMap<>();
	
	static {
		students.put(1, new Student(1, "AAA", 60.0));
		students.put(2, new Student(2, "BBB", 70.0));
		students.put(3, new Student(3, "CCC", 80.0));
		students.put(4, new Student(4, "DDD", 90.0));
		students.put(5, new Student(5, "EEE", 50.0));
		students.put(6, new Student(6, "FFF", 49.0));
		students.put(7, new Student(7, "GGG", 69.0));
		students.put(8, new Student(8, "HHH", 55.0));
		students.put(9, new Student(9, "III", 88.0));
		students.put(10, new Student(10, "JJJ", 92.0));
	}
	
	@Override
	public List<Student> getStudents() {
		List<Student> s = new ArrayList<>();
		for(Student student : students.values()) {
			s.add(student);
		}
		return s;
	}

	@Override
	public boolean addStudent(Student student) {
		if(students.containsKey(student.getRno()))
			return false;
		students.put(student.getRno(), student);
		return true;
	}

	@Override
	public boolean deleteStudent(Student student) {
		if(!students.containsKey(student.getRno()))
			return false;
		students.remove(student.getRno());
		return true;
	}

	@Override
	public Student getStudent(Integer rno) {
		return students.get(rno);
	}

	@Override
	public boolean updateStudent(Student student) {
		if(!students.containsKey(student.getRno()))
			return false;
		students.put(student.getRno(), student);
		return true;
	}

}
