package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestProduct {

	public static void main(String[] args) {
		int choice=0;
		ApplicationContext apt = new ClassPathXmlApplicationContext("springconfig.xml");
		ProductService pser = (ProductService) apt.getBean("p1");
		
		Scanner sc = new Scanner(System.in); 
		do {
			System.out.println("1) Add new Product \n 2)Show All Product \n 3)Delate Product by id \n "
					+ "4)Serach Product By id \n 5)Update product \n 6)Dispaly by Price \n 7)Exit   ");
			System.out.println("choice :");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				boolean status=pser.addProduct(); 
				break;
				
			case 2:
				List<Product>plist =pser.showAll(); 
				if(plist!=null) {
					plist.forEach(x->{System.out.println(x);});
				}else {
					System.out.println("No Product In Table");
				}
				break;
				
			case 3: 
				System.out.println("Enter id of Product to be Delete");
				int id =sc.nextInt();
				int rs=pser.deleteProduct(id);
				if(rs>0) {
					System.out.println("Deleted Successfully!!!");
				}else {
					System.out.println("Error Not Deleted");
				}
				break;
			
			case 4:
				System.out.println("Enter id of Product to be Delete");
				id =sc.nextInt();
				Product p = pser.serchById(id);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("Not Found!!");
				}
				break;
			default:
				break;
			}
			
		}while(choice!=7);
		
		
		
	}

}
