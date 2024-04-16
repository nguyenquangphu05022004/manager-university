package com.example.manageruniversity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ManagerUniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerUniversityApplication.class, args);
	}

}
