package com.demo.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.LoginServices;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginServices lser;
	@RequestMapping("/signin")
	public ModelAndView signInUser(@RequestParam String uname, @RequestParam String pass) {
		boolean status =lser.validateUser(uname,pass);
		if(status) {
			return new ModelAndView("redirect:product/showproduct");
		}else {
			//redirect to login page
			String str = "Wrong Credential ";
			return new ModelAndView("login","msg",str);
		}
	}
}
