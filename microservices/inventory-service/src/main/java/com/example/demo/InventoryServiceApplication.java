package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.Inventory.Inventory;
import com.example.demo.repository.Repo;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages = "com.example.demo")
public class InventoryServiceApplication {
	
//	@Bean
	public CommandLineRunner loadData(Repo iRepo) {
		return args->{
//			Inventory phone=Inventory.builder().build();
//			phone.setProductName("iPhone 14");
//			phone.setProductQuantity(10);
//			iRepo.save(phone);
			
			Inventory laptop=Inventory.builder().build();
			laptop.setProductName("Samsung Galaxy S23");
			laptop.setProductQuantity(0);
			iRepo.save(laptop);
			
			
			
			
		};
	}
	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
