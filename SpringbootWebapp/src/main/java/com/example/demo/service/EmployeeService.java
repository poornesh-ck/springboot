package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
public class EmployeeService {
	List<Employee> emplist=new ArrayList<Employee>();
	
	public String addEmployee(Employee emp) {
		
		
		
		
		
//		 int id=emp.getEid();
//		 String ename= emp.getEname();
//		 int salary=emp.getSalary();
//		 String dept=emp.getDept();
		 emplist.add(emp);
		 
		 System.out.println(emplist);
		 
		 
		
		return "product added";
		
		
	}
	
	public List<Employee> viewemplist(){
		return emplist;
		
	}


}
