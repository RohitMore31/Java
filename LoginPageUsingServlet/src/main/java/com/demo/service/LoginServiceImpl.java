package com.demo.service;

import com.demo.beans.User;

import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
	//create object of LoginDao
	private LoginDao loginDao;
	
	// constructor
	public LoginServiceImpl() {
	    loginDao=new LoginDaoImpl();
	}
	
	@Override
	public User validateUser(String uname, String pass) {
		return loginDao.validateUser(uname,pass);
}
}