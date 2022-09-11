package com.shopping.rest.web.shoppingrestweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ShoppingRestWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingRestWebApplication.class, args);
	}

}
