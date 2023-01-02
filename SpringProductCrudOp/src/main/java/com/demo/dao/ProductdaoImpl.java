package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductdaoImpl implements Productdao{
	
	@Autowired
	private JdbcTemplate jt;

	public List<Product> ShowAllProduct() {
		RowMapper rm=(rs,numrows)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			return p;
		};
		List<Product> plist=jt.query("select * from product", rm);
		return plist;
	}
	
	
}
