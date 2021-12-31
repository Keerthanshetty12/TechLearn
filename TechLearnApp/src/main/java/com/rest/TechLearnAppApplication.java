package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@CrossOrigin(origins = "http://localhost:4200")
public class TechLearnAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechLearnAppApplication.class, args);
	}
	/*
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.rest"))
			.paths(PathSelectors.any())
		//		.paths(PathSelectors.ant("/user/**"))
				.build()
				.apiInfo(metaInfo());
		
	}
	
	private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
        		" TechLearn Application(Sping Boot)",
        		"Developed during Spring Boot Rest Training in december 2021",
        		"1.0",
        		"Created by: ",
        		"kishor magar,\"priti chavan\",\"keerthan shetty\",\"mahesh aleti\",\"rushikesh landge\"",
        		"Licence 2.1.0",
        		"https://www.capgemini.com"
        );
		return apiInfo;
}
*/
}
