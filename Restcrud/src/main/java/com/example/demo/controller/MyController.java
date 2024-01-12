package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.repo.Repo;
import com.example.demo.service.EmployeeService;

@Controller
public class MyController {
	
	
	@Autowired
	Employee emp;
	
	@Autowired
	Repo r;
	
	@Autowired
	EmployeeService es;
	
//    @RequestMapping("/")
//	public String home() {
//		return "navbar.jsp";
//	}
//    
//    @RequestMapping("/home")
//   	public String nav (){
//   		return "navbar.jsp";
//   	}
	
//    @RequestMapping("/nav")
//   	public String navbar() {
//   		return "navbar.jsp";
//   	}
	
	
	@PostMapping("/employee")
	@ResponseBody
	public void  add(@RequestBody Employee emp) {
		
		
		r.save(emp);
		
		
	}
	
	
	
	@GetMapping("/employee")
	@ResponseBody
	public List<Employee> view() {
		
		return (List<Employee>) r.findAll(); 
		
	}
	
	@GetMapping("/employee/{eid}")
	@ResponseBody
	public Employee viewbyid(@PathVariable int eid) {
		
		return  r.findById(eid);
		
	}
	
	
	@DeleteMapping("/employee/{eid}")
	public void delete(@PathVariable("eid") int eid)
	{	
		es.deleteEmpid(eid);
		
		
	}	
	
	
	
	@RequestMapping("/search")
	@ResponseBody
	public ModelAndView find(String search,String input) {
		ModelAndView mv= new ModelAndView("view.jsp");
		
		
		switch(search) {
		case "id":
			int id=Integer.parseInt(input);
			mv.addObject("elist", r.findById(id));
//			mv.addObject("elist", r.findByDept(input));
			break;
			
			
		case "dept":
			
			mv.addObject("elist", r.findByDept(input));
			break;
		}
		
		return mv;
		
	}
	
//	@RequestMapping("/search1")
//	@ResponseBody
//	public ModelAndView find(int eid) {
//		ModelAndView mv= new ModelAndView("view.jsp");
//		mv.addObject("elist", r.findById(eid));
//		return mv;
//		
//	}
	

}
