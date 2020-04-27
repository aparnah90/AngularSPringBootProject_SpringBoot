package com.example.demo.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	private  UserRepository userRepository ;
	
	 public UserController(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		
		return (List<Users>) userRepository.findAll();
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody Users users) {
		
		 userRepository.save(users);
	}
	

}
