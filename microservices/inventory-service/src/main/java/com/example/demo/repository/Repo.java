package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Inventory.Inventory;

public interface Repo extends JpaRepository<Inventory, Integer> {
	
	List<Inventory> findByProductNameIn(List<String> productName);
	


}
