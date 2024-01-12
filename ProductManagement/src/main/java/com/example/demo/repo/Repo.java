package com.example.demo.repo;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import java.util.List;


@Component
public interface Repo extends JpaRepository<Product, String> {
	
	public List<Product>  findByPname(String pname);
	
	@Override <S extends Product> List<S> findAll(Example<S> example);

}
