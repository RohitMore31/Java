package com.demo.beans;

public class Qpaper {
	private String que;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private String ans;
	private String topic;
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "Qpaper [que=" + que + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3 + ", op4=" + op4 + ", ans=" + ans
				+ ", topic=" + topic + "]";
	}
	public Qpaper(String que, String op1, String op2, String op3, String op4, String ans, String topic) {
		super();
		this.que = que;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.ans = ans;
		this.topic = topic;
	}
	public Qpaper() {
		super();
	}
	
	public Qpaper(String ans) {
		this.ans=ans;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("Equals called!!"
//				+this.id+"===="+((Employee)obj).id);
//		return this.id==((Employee)obj).id;
//	}
//	
//	public int compareTo(Qpaper o) {
//		System.out.println("Equals called!!"
//				+this.ans+"===="+((Qpaper)obj).ans);
//		return this.id==((Employee)obj).id;
//		return 0;
//	}
	
	
	
}
