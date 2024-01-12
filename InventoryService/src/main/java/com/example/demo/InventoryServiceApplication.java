package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Inventory.Inventory;
import com.example.demo.repository.Repo;

@SpringBootApplication
public class InventoryServiceApplication {
	
//	@Bean
//	public CommandLineRunner loadData(Repo iRepo) {
//		return args->{
//			Inventory phone=Inventory.builder().build();
//			phone.setProductName("iPhone 14");
//			phone.setProductQuantity(10);
//			iRepo.save(phone);
//			
//			Inventory laptop=Inventory.builder().build();
//			laptop.setProductName("Asus vivobook 14");
//			laptop.setProductQuantity(10);
//			iRepo.save(laptop);
//			
//			
//			
//			
//		};
//	}
	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
