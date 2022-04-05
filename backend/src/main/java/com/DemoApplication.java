package com;

import java.io.File;
import java.util.List;

//import com.BrushCircle.controllers.TestController;
import com.BrushCircle.model.User;
//import com.BrushCircle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@ComponentScan({"com","com.BrushCircle.controllers"})
public class DemoApplication {

//	@Autowired
//	private UserRepository urepository;

	public static void main(String[] args) {
		//Creates the upload directory if it doesn't exist
//		new File(TestController.uploadDirectory).mkdir();

		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner() {
//		return args -> {
//			urepository.save(new User("John", "Doe", "JDoe@gmail.com", ));
//			urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
//		};
//	}

//	@GetMapping
//	public List<User> hello(){
//		return List.of(new User(1L, "mari1", "p@22w0rd", "Mariam", "Jones", "Creator", "mariam.jones@gmail.com"));
//	}


}
