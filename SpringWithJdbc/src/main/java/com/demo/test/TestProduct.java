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
		ProductService pser = (ProductService) apt.getBean("pservice");
		
		Scanner sc = new Scanner(System.in); 
		do {
			System.out.println("1)Add new Product \n 2)Show All Product \n 3)Delete Product by id \n "
					+ "4)Search Product By id \n 5)Update product   \n 6)Exit   ");
			System.out.println("choice :");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				// Add new Product if Added Then return status as true
				boolean status=pser.addProduct(); 
				if(status) {
					System.out.println("Product Added In Database");
				}else {
					System.out.println("Not Added Try Again");
				}
				break;
				
			case 2:
				// Showing All Product 
				List<Product>plist =pser.showAll(); 
				// Display on console
				if(plist!=null) {
					plist.forEach(x->{System.out.println(x);});
				}else {
					System.out.println("No Product In Table");
				}
				break;
				
			case 3: 
				//Delete Product by id 
				// Taking id from user
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
				//Search Product By id
				System.out.println("Enter id of Product to be Search");
				id =sc.nextInt();
				Product p = pser.serchById(id);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("Not Found!!");
				}
				break;
				
			case 5:
				// Update product
				System.out.println("Enter id of Product to be update");
				id =sc.nextInt();
				//Search Product By id
				p = pser.serchById(id);
				System.out.println(p);
				// Product is found then Update it
				 rs=pser.updateProduct(id);
				if(rs>0) {
					System.out.println("Updated Successfully!!!");
				}else {
					System.out.println("Error Not Updated");
				}
				break;
				
			case 6:
				System.out.println("Thank you :) ");
				sc.close();
				break;
				
			default:
				System.out.println("Wrong choice ");
				break;
			}
			
			
		}while(choice!=6);
		
	}

}
