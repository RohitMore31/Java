package com.demo.service;

import java.util.List;

import com.demo.beans.Qpaper;
import com.demo.dao.StudentdaoImpl;

public class StudentServiceImpl implements StudentService {
//	(uname varchar(20),email varchar(30), pass varchar(20),mark double);
	
	// creating ob of daoimpl
	StudentdaoImpl sdao;
	public StudentServiceImpl(){
		sdao = new StudentdaoImpl();
	}
	
	// pasing to dao
	public boolean addNewStudent(String uname, String pass, String email) {
		return sdao.AddNewStudent(uname,pass,email);
	}

	public boolean startExam(String pass, String email) {
		//passing to dao;
		return sdao.StartExam(pass,email);
	}

	public List<String> allQuestionAns() {
		return sdao.AllQuestionAns();
	}

	@Override
	public List<Qpaper> allQuestion(String topic) {
		// TODO Auto-generated method stub
		return sdao.AllQuestion();
	}
	
	
}
