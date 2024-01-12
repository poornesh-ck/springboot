package com.example.demo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService ps;
	
	
	
	@PostMapping
	public String createProduct(@RequestBody ProductRequest productRequest ) {
		System.out.println(productRequest);
		return ps.addproduct(productRequest);
		
		
	}
	
	@GetMapping
	public List<ProductResponse> getAllproducts(){
		return ps.getProducts();
	}
	
	

}
