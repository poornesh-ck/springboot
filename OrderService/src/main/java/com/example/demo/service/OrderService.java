package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderLineItemDtoList;
import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLineItems;
import com.example.demo.repository.OrderRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	public final OrderRepo orderRespository;
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order= new Order();
//		List<Order>or=new ArrayList<>();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderLineItems(orderRequest.getOrderLineItemDtoList().stream().map(dto->mapToDto(dto)).toList());
		orderRespository.save(order);
		
	}
	
	
	public OrderLineItems mapToDto(OrderLineItemDtoList dto) {
		return OrderLineItems.builder().pId(dto.getPId()).pName(dto.getPName()).pPrice(dto.getPPrice()).productQuantity(dto.getProductQuantity()).build();
		
	}
	

}
