package com.chary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// The spring boot application will start with main method
// it contains embedded tomcat
// @SpringBootApplication - it says it should start from here
// It includes @EnableAutoConfiguration, 

@SpringBootApplication
public class SpringBootEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx1Application.class, args);
	}

}
