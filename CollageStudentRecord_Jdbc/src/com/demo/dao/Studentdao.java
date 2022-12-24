package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

// Interface 

public interface Studentdao {

	//Adding new Student
	boolean AddNewStudent(Student std);

	//Display All Student
	List<Student> ShowAllStudent();

	//Finding student by id
	Student SearchByID(int n);

	//Finding Toper in particular subject
	Student FindSubTopper(int n);

	List<Student> RankStudent();

	boolean DeleteByID(int n);

	boolean UpdateMark(int subnum, int newMark, int n);

}
