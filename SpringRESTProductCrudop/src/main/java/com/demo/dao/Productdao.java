package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface Productdao {

	List<Product> showAll();

	int deleteProduct(int pid);

	int addProduct(Product p);

}
