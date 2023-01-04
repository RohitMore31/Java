package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartPage {
	
	@RequestMapping("/index")
	public String firstpage() {
		return "index";
	}

}
