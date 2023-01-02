package com.demo.dao;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;

@Repository
public class logindaoImpl implements logindao {
	
	@Autowired
	private JdbcTemplate jt;

	public boolean Validateuser(String uname, String pass) {
		User u = jt.queryForObject("select * from user where uname=? and pass=?",new Object[]{uname,pass},
				BeanPropertyRowMapper.newInstance(User.class));
		if(u!=null) {
			return true;
		}else {
			return false;			
		}
		
	}

}
