package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestInventory;
import com.example.demo.dto.ResponseInventory;
import com.example.demo.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Inventory")
@RequiredArgsConstructor
public class InventoryController {
	
	private final InventoryService iService;
	@GetMapping
	public List<RequestInventory> isInstock(@RequestParam List<String> productNames){
		return iService.isInStock(productNames);
		
	}
	
	@PostMapping
	public String addprodcuts(@RequestBody ResponseInventory invParam ) {
		iService.addProduct(invParam);
		return "jhd";
	}

}
