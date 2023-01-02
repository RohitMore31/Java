package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.logindao;
import com.demo.dao.logindaoImpl;

@Service
public class LoginServicesImpl implements LoginServices{
	@Autowired
	logindao ldao;
	public LoginServicesImpl() {
		ldao = new logindaoImpl();
	}
	public boolean validateUser(String uname, String pass) {
		return ldao.Validateuser(uname,pass);
	}
	
	
}
