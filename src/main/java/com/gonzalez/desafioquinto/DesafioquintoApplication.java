package com.gonzalez.desafioquinto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DesafioquintoApplication {

	@GetMapping("/")
	String home() {
		return "Spring is here!";
	}
	public static void main(String[] args) {
		SpringApplication.run(DesafioquintoApplication.class, args);
	}

}
