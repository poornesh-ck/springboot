package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.Repo;

@RestController
@RequestMapping("/app")
public class HomeController {
	
	@Autowired
	Repo re;
	
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		User user=new User();
		user.setUid(18);
		user.setUserName("admin");
		user.setPassword(new BCryptPasswordEncoder().encode("123"));
		re.save(user);
		return ResponseEntity.ok("I am a Public user");
	}
	
	
	@GetMapping("/admin")
    public ResponseEntity<String> adminUser(){
		
		return ResponseEntity.ok("I am a Admin user");
	}
	

}
