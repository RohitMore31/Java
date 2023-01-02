package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyFirtController {
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView printHell() {
		String str = "Hellow Rohit";
		return new ModelAndView("rohit","ptr",str);
	}
}
