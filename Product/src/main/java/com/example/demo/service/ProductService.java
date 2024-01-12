package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository pRepo;
	
	public String addproduct(ProductRequest productRequest) {
//		Product p=new Product();
		Product p=Product.builder()
				.pName(productRequest.getPName())
				.pPrice(productRequest.getPPrice())
				.pQty(productRequest.getPQty()).build();
		
		
//		p.setPName(productRequest.getPName());
//		p.setPPrice(productRequest.getPPrice());
//		p.setPQty(productRequest.getPQty());
		pRepo.save(p);
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
