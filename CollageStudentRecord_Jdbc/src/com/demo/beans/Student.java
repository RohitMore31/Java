package com.demo.beans;

public class Student {
	private int id;
	private String name;
	private float sub1;
	private float sub2;
	private float sub3;
	private float percentage;
	
	//Parameter less Constructor
	public Student() {
		super();
	}
	
	//Parameterized  Constructor
	public Student(int id, String name, float sub1, float sub2, float sub3) {
		super();
		this.id = id;
		this.name = name;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.percentage = (sub1+sub2+sub3) * 0.3f;
	}
	
	// Getter And Setter 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSub1() {
		return sub1;
	}
	public void setSub1(float sub1) {
		this.sub1 = sub1;
	}
	public float getSub2() {
		return sub2;
	}
	public void setSub2(float sub2) {
		this.sub2 = sub2;
	}
	public float getSub3() {
		return sub3;
	}
	public void setSub3(float sub3) {
		this.sub3 = sub3;
	}
	
	// ToString
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3
				+ ", percentage=" + percentage + "]";
	}
	
	
}
