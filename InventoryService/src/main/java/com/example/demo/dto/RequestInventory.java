package com.example.demo.dto;

import com.example.demo.Inventory.Inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestInventory {
	private String productName;
	private Boolean productQuantity;

}
