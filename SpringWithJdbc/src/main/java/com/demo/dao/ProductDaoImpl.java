package com.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
		int n = jdbcTemp.update("insert into product values(?,?,?,?,?)",new Object [] {p.getPid(),p.getPname(),p.getPrice(),p.getQty(),p.getCategory()});
		if(n>0) {
			return true;
		}
		else 
			return false;
	}

	@Override
	public List<Product> ShowAll() {
		RowMapper rm = (rs,numofrwo)->{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getFloat(3));
			p.setQty(rs.getInt(4));
			p.setCategory(rs.getString(5));
			return p;
		};
		
		// we not need to list it automatically added each object return by rm into List 
		List<Product> plist = jdbcTemp.query("select * from product", rm);
		return plist;
	}

	@Override
	public int DeleteProduct(int id) {
		 return jdbcTemp.update("Delete from product where pid =?",new Object [] {id} );
	}

	@Override
	public Product SerchById(int id) {
		return jdbcTemp.queryForObject("Select * from Product where pid=?", new Object [] {id},BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public int UpdateProduct(Product p) {
		return jdbcTemp.update("update product set qty=?,price=? where pid=?",
				new Object[] {p.getQty(),p.getPrice(),p.getPid()});
	}
	
	
}
