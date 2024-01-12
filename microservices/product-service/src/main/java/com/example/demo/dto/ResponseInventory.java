package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//this is requestbody
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseInventory {
	private String productName;
	private Integer productQuantity;

}
