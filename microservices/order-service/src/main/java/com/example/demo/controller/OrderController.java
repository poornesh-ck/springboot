package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@PostMapping("/add")
	@CircuitBreaker(name="inventory",fallbackMethod="fallBackMethod")
	@TimeLimiter(name="inventory")
	public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
		String msg=orderService.placeOrder(orderRequest);
		return CompletableFuture.supplyAsync(()->msg) ;
		
	}
	
	@GetMapping("/product")
	public ProductResponse[] viewproducts(){
		return orderService.viewproducts();
		
	}
	
	public CompletableFuture<String> fallBackMethod(OrderRequest orderRequest,RuntimeException exception) {
		System.out.println("FallBack Mechanism");
		return CompletableFuture.supplyAsync(()->"call back method error in placing order");
		
	}

}
