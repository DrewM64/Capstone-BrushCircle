package com;

import java.util.List;

import com.BrushCircle.model.Artist;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.ArtistRepository;
import com.BrushCircle.repository.ProductRepository;
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
	private ArtistRepository artistRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Artist artist1 = new Artist("Mathew", "Jordan");
			artistRepo.save(artist1);
			productRepo.save(new Product(99, artist1.getName(), "Statue of David", "Sculpture", "Inspired by Picasso", "davidStatue.jpg", artist1));
		};
	}
}
