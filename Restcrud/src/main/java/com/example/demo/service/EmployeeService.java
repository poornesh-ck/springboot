package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.Repo;

@Service
public class EmployeeService {
	@Autowired
	Repo re;
	
	public void deleteEmpid(int eid) {
		re.deleteById(eid);
		
		
		
	}

}
