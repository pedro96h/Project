package com.example.demo.conf;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SpringFoxConfig {
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api.*")).build().apiInfo(metainfo());
	}

	private ApiInfo metainfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Swagger API REST", "REST api for shop", "1.0", "Service Terms",
				"https://www.linkedin.com/in/pedro96h/", "None", "None");
		return apiInfo;
	}
}
