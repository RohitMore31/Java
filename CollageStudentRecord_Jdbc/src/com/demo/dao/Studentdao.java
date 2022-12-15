package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

public interface Studentdao {

	boolean AddNewStudent(Student std);

	List<Student> ShowAllStudent();

	Student SearchByID(int n);

	Student FindSubTopper(int n);

}
