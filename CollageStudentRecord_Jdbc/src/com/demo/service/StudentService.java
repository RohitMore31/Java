package com.demo.service;

import java.util.List;

import com.demo.beans.Student;

//Service Interface included Business Logic
public interface StudentService {

	// Add New Student
	boolean addNewStudent();

	//Show All Student
	List<Student> showAllStudent();

	//Search Student
	Student searchByID(int n);

	// Find Toper
	Student findSubTopper(int n);

	// Rank Student Based On Percentage 
	List<Student> rankStudent();

	// Delete Student Record
	boolean deleteByID(int n);

	// Update Mark Of Student
	boolean updateMark(int subnum, int newMark, int n);

}
