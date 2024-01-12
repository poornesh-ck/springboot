package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Employee;
import com.example.demo.repo.Repo;

@Controller
public class MyController {
	
	
	@Autowired
	Employee emp;
	
	@Autowired
	Repo r;
	
    @RequestMapping("/")
	
	public String home() {
		return "index.jsp";
		
		
		
	}
	
	
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(Employee emp) {
		
		r.save(emp);
		return "created";
		
		
	}
	@RequestMapping("/view")
	@ResponseBody
	public String view() {
		return r.findAll().toString();
	}
	

}
