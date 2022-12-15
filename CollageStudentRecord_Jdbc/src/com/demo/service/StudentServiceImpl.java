package com.demo.service;

import com.demo.dao.Studentdao;
import com.demo.dao.StudentdaoImpl;

public class StudentServiceImpl implements StudentService{
	Studentdao simpl;

	public StudentServiceImpl() {
		simpl = new StudentdaoImpl();
	}
	
	
	
}
