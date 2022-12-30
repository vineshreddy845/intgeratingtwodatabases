package com.example.integerationwithtwodatabases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.example.integerationwithtwodatabases.response.Response"})
public class IntegerationwithtwodatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegerationwithtwodatabasesApplication.class, args);
	}

}
