package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.Productdao;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private Productdao pdao;

	@Override
	public List<Product> dispalyProduct() {
		return pdao.showAll();
	}

	@Override
	public int deletebyid(int pid) {
		return pdao.deleteProduct(pid);
	}

	@Override
	public int addnewProduct(Product p) {
		return pdao.addProduct(p);
	}
	
	
	
}
