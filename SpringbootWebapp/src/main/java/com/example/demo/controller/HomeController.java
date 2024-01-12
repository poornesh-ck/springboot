package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeService es;
	
	@Autowired
	Employee emp;
	
	
	@RequestMapping("/")
	
	public String home() {
		return "index.jsp";
		
		
		
	}
	@RequestMapping("/poornesh")
	public ModelAndView display(String uname)
	
	{
		
		ModelAndView mv=new ModelAndView("display.jsp");
		mv.addObject("uname",uname);
		return mv;
		
	}
	
//display using @Response body
	@RequestMapping("/poornesh1")
	@ResponseBody
	public String responsemethod(String uname) {
		return "welcome "+uname;
	}
	
	@RequestMapping("/add")

	
	public ModelAndView add(int eid,String ename,int salary,String departments)
	{
		ModelAndView mv=new ModelAndView("index.jsp");
		emp.setEid(eid);
		emp.setEname(ename);
		emp.setSalary(salary);
		emp.setDept(departments);
		String o=es.addEmployee(emp);
		mv.addObject("o",o);
		return mv;
		
		
		
		
		
	}
	
	@RequestMapping("/view")
	public ModelAndView view() {
		ModelAndView mv=new ModelAndView("display.jsp");
		List<Employee> elist = es.viewemplist();
		return mv.addObject("elist",elist);
		
	}
	
	

}
