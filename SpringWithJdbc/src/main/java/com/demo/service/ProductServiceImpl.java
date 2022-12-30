package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	ProductDao pdao;
	// Constructor
	public ProductServiceImpl() {
	}

	// getter and Setter
	public ProductDao getPdao() {
		return pdao;
	}
	public void setPdao(ProductDao pdao) {
		this.pdao = pdao;
	}

	
	@Override
	public boolean addProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pid");
		int pid=sc.nextInt();
		System.out.println("enter pname");
		String pname=sc.next();
		System.out.println("enter qty");
		int qty=sc.nextInt();
		System.out.println("enter price");
		float price=sc.nextFloat();
		System.out.println("enter category");
		String category=sc.next();
		Product p=new Product(pid,pname,price,qty,category);
		return pdao.AddProduct(p);
	}

	@Override
	public List<Product> showAll() {
		return pdao.ShowAll();
	}

	@Override
	public int deleteProduct(int id) {
		return pdao.DeleteProduct(id);
	}

	@Override
	public Product serchById(int id) {
		return pdao.SerchById(id);
	}

	
}
