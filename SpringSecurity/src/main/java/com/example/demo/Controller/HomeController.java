package com.example.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {
	@RequestMapping("/public")
	@ResponseBody
	public String publicUser() {
		return "I am Public User";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/admin")
	@ResponseBody
	public String adminUser() {
		return "I am admin User";
	}
	@PreAuthorize("hasRole('CUSTOMER')")
	@RequestMapping("/customer")
	@ResponseBody
	public String customerUser() {
		return "I am customer User";
	}

}
