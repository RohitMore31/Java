package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductServices;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductServices pser;

	@RequestMapping("/showproduct")
	public ModelAndView showAllP() {
		System.out.println("inside showproduct");
		
		List<Product>plist = pser.showAllProduct();
		if(plist!=null) {
			return new ModelAndView("displayProduct","lst",plist);
		}else {
			String str="not found";
			return new ModelAndView("login","msg",str);
		}
	}
}
