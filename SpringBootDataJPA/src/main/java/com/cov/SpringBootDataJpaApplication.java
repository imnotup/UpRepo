package com.cov;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBootDataJpaApplication.class, args);

		
	}

}