package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Inventory.Inventory;
import com.example.demo.dto.RequestInventory;
import com.example.demo.repository.Repo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
	private final Repo iRepo;
	
	public List<RequestInventory> isInStock(List<String> pName){
		List<Inventory> iList=iRepo.findByProductNameIn(pName);
		List<RequestInventory> rList=iList.stream().map(product->mapToRequestInventory(product)).toList();
		
		return rList;
	}
	
	public RequestInventory mapToRequestInventory(Inventory inv) {
		return RequestInventory.builder().productName(inv.getProductName()).productQuantity(inv.getProductQuantity()>0).build();
		
	}
	

}
