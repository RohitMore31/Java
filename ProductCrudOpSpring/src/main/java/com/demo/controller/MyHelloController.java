package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyHelloController {
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView sayHello() {
		String str="Hello world1111!!";    
		return new ModelAndView("displayhello","msg",str);
	}
}
