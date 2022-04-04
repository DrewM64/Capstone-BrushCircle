package com;

import java.util.List;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.ProductRepository;
import com.BrushCircle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class DemoApplication {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private UserRepository userRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
//			User user1 = new User("", "", "", "", "", "", "", "", "", "", "");
//			userRepo.save(user1);
//			productRepo.save(new Product(99, user1.getFirstName() + user1.getLastName(), "Statue of David", "Sculpture", "Inspired by Picasso", "davidStatue.jpg", user1));
			System.out.println("Hello");
		};
	}
}
