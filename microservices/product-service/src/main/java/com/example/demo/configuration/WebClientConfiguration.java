package com.example.demo.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class WebClientConfiguration {
	@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder() 
	{
		return WebClient.builder();
	}
	
//	@Bean
//	public ObjectMapper objectMapper() {
//		return objectMapper().
//	}

}
