package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;

public class TestStudent {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentService ss = new StudentServiceImpl();
		int choice =0;
		do {
			System.out.println("==============Menu+==============\n");
			System.out.println("1)Add New Student \n "
					+ "2)Search Student by id \n "
					+ "3)Show All Student \n"
					+ "4)Show First Student on Any Subject\n"
					+ "5)Show Ranking of Student Percertage \n "
					+ "6)Delete Student\n"
					+ "7)Correct Mark of Subject Of Student \n "
					+ "8)Exit \n");
			System.out.println("enter the choice ");
			choice=sc.nextInt();

			switch(choice) {
			case 1:
				// Adding New Student
				boolean status = ss.addNewStudent();
				if(status) {
					System.out.println("Inserted Sucessfully!! ");
				}else{
					System.out.println("Error .. Try Again");
				}
				break;
				
			case 2:
				// Searching Student
				// Giving id of Student from User
				System.out.println("Enter Id of Student");
				int n =sc.nextInt();
				Student std = ss.searchByID(n);
				System.out.println(std);
				break;
				
			case 3: 
				List<Student> lst = ss.showAllStudent();
				lst.forEach(System.out::println);
				break;
				
			case 4:
				System.out.println("Enter Subject id 1/2/3 ");
				n =sc.nextInt();
				std = ss.findSubTopper(n);
				System.out.println(std);
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
