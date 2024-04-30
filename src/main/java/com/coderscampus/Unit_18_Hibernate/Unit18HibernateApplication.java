package com.coderscampus.Unit_18_Hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com/coderscampus/Unit_18_Hibernate/domain")
public class Unit18HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(Unit18HibernateApplication.class, args);
	}

}
