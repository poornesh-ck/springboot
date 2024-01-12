package com.example.demo.dto;

import com.example.demo.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
	
	 private String pName;
	 private Double pPrice;
	 private Integer pQty;


}
