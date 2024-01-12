package com.example.demo.dto;

import com.example.demo.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	
	 private Integer pId;
	 private String pName;
	 private Double pPrice;
	 private Integer pQty;


}
