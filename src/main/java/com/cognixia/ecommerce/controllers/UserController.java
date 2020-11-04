package com.cognixia.ecommerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.ecommerce.models.User;
import com.cognixia.ecommerce.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	@GetMapping()
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}