package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MenuManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuManagementApplication.class, args);
	}

    @Bean
    RestTemplate getRestTemplateObject() {
    	return new RestTemplate();
	}
}
