package com.example.cardetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@EnableSwagger2
@SpringBootApplication
public class CarDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDetailsApplication.class, args);
	}
	 @Profile("!production")
	 @Bean
	    public Docket swagger() {
	        return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.example.cardetails.controller"))  // Specify the base package for scanning controllers
	            .paths((Predicate<String>) PathSelectors.any())
	            .build();
	    }


}
