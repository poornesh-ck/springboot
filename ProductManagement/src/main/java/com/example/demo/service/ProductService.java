package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.Repo;

@Service
public class ProductService {
	@Autowired
	Repo r;
	
	public void addProducts(Product p) {
		r.save(p);
	}
	
	public List<Product> getproducts(){
		List<Product> viewList=r.findAll();
		return viewList;
	}
	
	
	public Product getProduct(String pid) {
		return r.findById(pid).get();
	}
	
	public void removeProduct(String pid) {
		r.deleteById(pid);
	}
	
	public void update(Product p) {
		r.save(p);
	}
	
	public List<Product> searchProducts(String pname) {
		return r.findByPname(pname);
	}
	
	

}
