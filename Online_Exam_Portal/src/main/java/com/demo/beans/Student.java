package com.demo.beans;

public class Student {
	private String uname;
	private String pass;
	private String email;
	private double mark;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "Student [uname=" + uname + ", pass=" + pass + ", email=" + email + ", mark=" + mark + "]";
	}
	public Student(String uname, String pass, String email, double mark) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.email = email;
		this.mark = mark;
	}
	
	public Student(String uname, String pass, String email) {
		this.uname = uname;
		this.pass = pass;
		this.email = email;
	}
	
	public Student() {
		this.uname = null;
		this.pass = null;
		this.email = null;
		this.mark = 0;
	}
	
}
