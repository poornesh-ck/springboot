package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;

@Component
public interface Repo extends CrudRepository<Employee, Integer> {
	
	

}
