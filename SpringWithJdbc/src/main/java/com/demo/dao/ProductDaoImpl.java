package com.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	JdbcTemplate jdbcTemp;

	// Default Constructor
	public ProductDaoImpl() {
		super();
	}

	//Getter and Setter
	public JdbcTemplate getJdbcTemp() {
		return jdbcTemp;
	}

	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}

	
	@Override
	public boolean AddProduct(Product p) {
		return false;
	}

	@Override
	public List<Product> ShowAll() {
		return null;
	}

	@Override
	public int DeleteProduct(int id) {
		return 0;
	}

	@Override
	public Product SerchById(int id) {
		return null;
	}
	
	
}
