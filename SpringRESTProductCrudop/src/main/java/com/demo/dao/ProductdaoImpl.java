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
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> showAll() {
		RowMapper rm = (rs,numofrows)->{
			Product p =new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			return p;
		};
		List<Product>plist=jdbcTemplate.query("select * From Product4", rm);
		return plist;
	}

	@Override
	public int deleteProduct(int pid) {
		int n = jdbcTemplate.update("delete from product4 where pid=?",new Object[] {pid});
		return n;
	}

	@Override
	public int addProduct(Product p) {
		int n =jdbcTemplate.update("insert into product4 values(?,?,?,?)",new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		return n;
	}
	
}
