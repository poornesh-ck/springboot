package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Inventory.Inventory;
import com.example.demo.dto.RequestInventory;
import com.example.demo.dto.ResponseInventory;
//import com.example.demo.model.Product;
import com.example.demo.repository.Repo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
	private final Repo iRepo;
	
	public List<RequestInventory> isInStock(List<String> pName){
		try {
			System.out.println("Thread started sleeping");
			Thread.sleep(10000);
			System.out.println("Thread Awake");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Inventory> iList=iRepo.findByProductNameIn(pName);
		List<RequestInventory> rList=iList.stream().map(product->mapToRequestInventory(product)).toList();
	
		return rList;
	
	}
	
	public void  addProduct(ResponseInventory rs) {
		Inventory p=Inventory.builder().productName(rs.getProductName()).productQuantity(rs.getProductQuantity()).build();
		
		
//		p.setPName(productRequest.getPName());
//		p.setPPrice(productRequest.getPPrice());
//		p.setPQty(productRequest.getPQty());
		
		iRepo.save(p);
		
	}
	
	public RequestInventory mapToRequestInventory(Inventory inv) {
		return RequestInventory.builder().productName(inv.getProductName()).productQuantity(inv.getProductQuantity()>0).build();
		
	}
	

}
