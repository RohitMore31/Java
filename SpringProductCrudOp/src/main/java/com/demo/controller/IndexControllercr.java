package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllercr {
	
	@RequestMapping("/index")
	public String showStarPage() {
		System.out.println("passing to login page");
		return "login";
	}
}
