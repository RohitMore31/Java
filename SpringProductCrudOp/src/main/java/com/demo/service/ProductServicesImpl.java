package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.Productdao;
import com.demo.dao.ProductdaoImpl;

@Service
public class ProductServicesImpl implements ProductServices{
	private Productdao pdao;
	@Autowired
	public ProductServicesImpl() {
		pdao= new ProductdaoImpl();
	}
	public List<Product> showAllProduct() {
		return pdao.ShowAllProduct();
	}
	
}
