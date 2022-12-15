package com.demo.service;

import java.util.List;

import com.demo.beans.Student;

public interface StudentService {

	boolean addNewStudent();

	List<Student> showAllStudent();

	Student searchByID(int n);

	Student findSubTopper(int n);

}
