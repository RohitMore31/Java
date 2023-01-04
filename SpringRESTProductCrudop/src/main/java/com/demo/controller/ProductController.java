package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService pser;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> showProduct() {
		List<Product> plist = pser.dispalyProduct();
		return ResponseEntity.ok(plist);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") int pid){
		int n= pser.deletebyid(pid);
		if(n>0) {
			return new ResponseEntity("Deleted Sucessfully"+pid,HttpStatus.OK);
		}
		return new ResponseEntity("Not Deleted "+pid,HttpStatus.NOT_FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product p){
		int n =pser.addnewProduct(p);
		return ResponseEntity.ok(p);
	}
}
