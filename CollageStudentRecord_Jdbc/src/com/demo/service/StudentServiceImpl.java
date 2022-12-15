package com.demo.service;

import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.dao.Studentdao;
import com.demo.dao.StudentdaoImpl;

public class StudentServiceImpl implements StudentService{
	Studentdao simpl;

	Scanner sc = new Scanner(System.in);
	
	public StudentServiceImpl() {
		simpl = new StudentdaoImpl();
	}

	@Override
	public boolean addNewStudent() {
		System.out.println("Enter Id ");
		int id = sc.nextInt();
		System.out.println("Enter Name ");
		String name =sc.next();
		System.out.println("Sub1 Mark ");
		int sub1 = sc.nextInt();
		System.out.println("Sub2 Mark ");
		int sub2 = sc.nextInt();
		System.out.println("Sub3 Mark ");
		int sub3 = sc.nextInt();
		Student std = new Student(id, name, sub1, sub2, sub3);
		return simpl.AddNewStudent(std);
	}
	
	
	
}
