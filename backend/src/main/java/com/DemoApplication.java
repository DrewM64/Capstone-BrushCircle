package com;

import java.util.List;

import com.BrushCircle.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public List<User> hello(){
		return List.of(new User(1L, "mari1", "p@22w0rd", "Mariam", "Jones", "Creator", "mariam.jones@gmail.com"));
	}
}
