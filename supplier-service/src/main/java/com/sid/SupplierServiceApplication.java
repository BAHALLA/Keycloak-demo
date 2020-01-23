package com.sid;

import com.sid.dao.SupplierRepository;
import com.sid.entities.Supplier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class SupplierServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(SupplierRepository supplierRepository,
								   RepositoryRestConfiguration restConfiguration) {
		return args -> {
			restConfiguration.exposeIdsFor(Supplier.class);
			supplierRepository.save(new Supplier(null, "ibm", "contact@ibm.com"));
			supplierRepository.save(new Supplier(null, "hp", "contact@hp.com"));
			supplierRepository.save(new Supplier(null, "dell", "contact@dell.com"));
		};
	}
}
