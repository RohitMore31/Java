package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean AddProduct(Product p);

	List<Product> ShowAll();

	int DeleteProduct(int id);

	Product SerchById(int id);

}
