package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addProduct();

	List<Product> showAll();

	int deleteProduct(int id);

	Product serchById(int id);

	int updateProduct(int id);

}
