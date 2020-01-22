package org.sid;

import org.sid.dao.ProductRepository;
import org.sid.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsAppApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null, "Dell xps 2018", 20000.58));
			productRepository.save(new Product(null, "MacBook pro 2016 ", 20050.58));
			productRepository.save(new Product(null, "Lenovo 2019", 19250.36));
		};
	}
}
