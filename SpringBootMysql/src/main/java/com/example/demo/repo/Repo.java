package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import java.util.List;


@Component
public interface Repo extends CrudRepository<Employee, Integer> {
	public List<Employee>  findByDept(String dept);
	public List<Employee>  findById(int id);
	

}
