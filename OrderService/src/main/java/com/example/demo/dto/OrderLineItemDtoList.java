package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItemDtoList {
	private Integer pId;
	private String pName;
	private Double pPrice;
	private Integer productQuantity;

}
