package com.somecompany.someproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableSpringConfigured
@EnableTransactionManagement
public class SomeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		final ApplicationContext applicationContext = SpringApplication.run(SomeApplication.class, args);
		System.out.println(1);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SomeApplication.class);
	}

}
