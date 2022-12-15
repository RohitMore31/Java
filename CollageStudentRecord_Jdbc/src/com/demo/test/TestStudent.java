package com.demo.test;

import java.util.Scanner;

import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;

public class TestStudent {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StudentService ss = new StudentServiceImpl();
		int choice =0;
		do {
			System.out.println("==============Menu+==============");
			System.out.println("1)Add New Student \n 2)Search Student by Name \n "
					+ "3)Show All Student 4)Show First Student on Any Subject\n"
					+ "5)Show Ranking of Student Percertage \n 6)Delete Student\n"
					+ "7)Correct Mark of Subject Of Student \n 8)Exit ");
			System.out.println("enter the choice ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				boolean status = ss.addNewStudent();
				if(status) {
					System.out.println("Inserted Sucessfully!! ");
				}else{
					System.out.println("Error .. Try Again");
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				System.out.println("Thank you !!!!!! :)  ");
				sc.close();
				break;
			default:
				System.out.println("invalid choice...");
			}
		}while(choice!=8);
	}
}
