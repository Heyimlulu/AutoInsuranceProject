package com.namai.assurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AssuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceApplication.class, args);
	}

}
