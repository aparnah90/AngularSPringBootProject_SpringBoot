package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args ->{
			Stream.of("John","Julie","Jennifer","Helen").forEach(name->{
				Users user =new Users(name,name.toLowerCase()+"@domain.com");
			userRepository.save(user);
				
			});
			 userRepository.findAll().forEach(System.out::println);
		};
		
		
	}

}
