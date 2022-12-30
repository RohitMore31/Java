package com.demo.service;

import java.util.List;

import com.demo.beans.Qpaper;

public interface StudentService {
	
	public boolean addNewStudent(String uname, String pass, String email);

	public boolean startExam(String pass, String email);
	
	public List<Qpaper> allQuestion(String topic);

	public List<String> allQuestionAns();
}
