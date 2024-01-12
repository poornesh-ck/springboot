package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
//import com.example.demo.dto.RequestInventory;
import com.example.demo.dto.ResponseInventory;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository pRepo;
	private final WebClient.Builder webClientBuilder;
	
	ObjectMapper objectMapper=new ObjectMapper();
	public String addproduct(ProductRequest productRequest)  {
//		Product p=new Product();
		Product p=Product.builder()
				.pName(productRequest.getPName())
				.pPrice(productRequest.getPPrice())
				.pQty(productRequest.getPQty()).build();
		pRepo.save(p);
		
//		p.setPName(productRequest.getPName());
//		p.setPPrice(productRequest.getPPrice());
//		p.setPQty(productRequest.getPQty());
		
		ResponseInventory ri=ResponseInventory.builder().productName(p.getPName()).productQuantity(p.getPQty()).build();
         
//		webClient.get().uri("http://localhost:8003/Inventory/add",uriBuilder->uriBuilder.queryParam("invParam", ri).build());
		
		try {
			webClientBuilder.build().post()

			.uri("http://INVENTORY-SERVICE/Inventory")

			.contentType(MediaType.APPLICATION_JSON)

			.body(BodyInserters.fromValue(objectMapper.writeValueAsString(ri)))

			.retrieve()

			.toBodilessEntity()

			.block();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		RequestInventory[] inventoryResponseArray= webClient.get()
//		.uri("http://localhost:8003/Inventory",uriBuilder->uriBuilder.queryParam("productNames", productNames).build())
//		.retrieve().bodyToMono(RequestInventory[].class).block();
//		String msg=null;
		
		
		return "added";
		
		
	}
	
	public List<ProductResponse> getProducts(){
		List<Product> products=pRepo.findAll();
		List<ProductResponse> responseProduct=products.stream().map(pro->mapToProductResponse(pro)).toList();
		return responseProduct;
	}
	public ProductResponse mapToProductResponse(Product pro) {
		ProductResponse pr=new ProductResponse();
		pr.setPId(pro.getPId());
		pr.setPName(pro.getPName());
		pr.setPPrice(pro.getPPrice());
		pr.setPQty(pro.getPQty());
		return pr;
	}

}
