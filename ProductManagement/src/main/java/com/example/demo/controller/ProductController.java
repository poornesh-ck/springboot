package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService ps;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add")
	@ResponseBody
	public void add(@RequestBody Product p) {
		ps.addProducts(p);
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/edit")
	public Product editProducts(@RequestBody Product p) {
		ps.update(p);
		return p;
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/products")
	public List<Product> view() {
		List<Product> li=ps.getproducts();
		return li;
		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/products/{pname}")
	public Product viewProducts(@PathVariable String pname) {
		return ps.getProduct(pname);
		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/products/{pid}")
	public void deleteProducts(@PathVariable String pid) {
		ps.removeProduct(pid);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/search/{pname}")
	public List<Product> searchProducts(@PathVariable String pname) {
		return ps.searchProducts(pname);
	}
	
	
	
	
	
	

}
