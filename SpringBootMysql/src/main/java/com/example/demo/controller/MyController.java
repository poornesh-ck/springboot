package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
    @RequestMapping("/")
	public String home() {
		return "navbar.jsp";
	}
    
    @RequestMapping("/home")
   	public String nav (){
   		return "navbar.jsp";
   	}
	
//    @RequestMapping("/nav")
//   	public String navbar() {
//   		return "navbar.jsp";
//   	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public ModelAndView  add(Employee emp) {
		ModelAndView mv =new ModelAndView("index.jsp");
		String pc="Product Created";
		mv.addObject("pc",pc);
		r.save(emp);
		return mv;
		
		
	}
	
	
	
	@RequestMapping("/view")
	@ResponseBody
	public ModelAndView view() {
		ModelAndView mv= new ModelAndView("view.jsp");
		mv.addObject("elist", r.findAll());
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(int eid)
	{	ModelAndView mv=new ModelAndView("view");
		es.deleteEmpid(eid);
		return mv;
		
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
