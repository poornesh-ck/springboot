package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.example.demo.dto.OrderLineItemDtoList;
import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.dto.RequestInventory;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLineItems;
import com.example.demo.repository.OrderRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepo orderRespository;
	
	private final WebClient.Builder webClientBuilder;
	
	public String placeOrder(OrderRequest orderRequest) {
		Order order= new Order();
//		List<Order>or=new ArrayList<>();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderLineItems(orderRequest.getOrderLineItemDtoList().stream().map(dto->mapToDto(dto)).toList());
//		orderRespository.save(order);
		
		List<String> productNames=order.getOrderLineItems().stream().map(orderItemList->orderItemList.getPName()).toList();
		
		RequestInventory[] inventoryResponseArray=  webClientBuilder.build().get()
		.uri("http://INVENTORY-SERVICE/Inventory",uriBuilder->uriBuilder.queryParam("productNames", productNames).build())
		.retrieve().bodyToMono(RequestInventory[].class).block();
		String msg=null;
		
		boolean stockCheckStatus= Arrays.stream(inventoryResponseArray).allMatch(inventory->inventory.isProductQuantity());
		
		
		
		if(stockCheckStatus ) {
			orderRespository.save(order);
			msg="Order place Succesfully";
		}
		else {
			msg="Some of the Product are out of stock";
//			throw new IllegalArgumentException("Some of the Product are out of stock");
			
		}
		return msg;
		
	}
	
	public ProductResponse[] viewproducts(){
		return  webClientBuilder.build().get().uri("http://PRODUCT-SERVICE/product").retrieve().bodyToMono(ProductResponse[].class).block();
	}
	
	
	public OrderLineItems mapToDto(OrderLineItemDtoList dto) {
		return OrderLineItems.builder().pId(dto.getPId()).pName(dto.getPName()).pPrice(dto.getPPrice()).productQuantity(dto.getProductQuantity()).build();
		
	}
	

}
