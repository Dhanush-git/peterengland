package com.group2.peterengland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PeterenglandApplication {


	public static void main(String[] args) {
		SpringApplication.run(PeterenglandApplication.class, args);
		System.out.println("server is online");
	}

	@GetMapping
	public String helloWorld(){
		return "Server is online";
	}

}
