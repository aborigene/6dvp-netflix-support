package com.dvp6.grupo1.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dvp6.grupo1.support.*")
public class SupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportApplication.class, args);
	}

}
