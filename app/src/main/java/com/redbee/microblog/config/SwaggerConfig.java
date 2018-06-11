package com.redbee.microblog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.redbee.microblog.controller"))
                .paths(regex("/.*"))
                //.paths(regex("/traveler.*"))
                //.paths(regex("/postmentions.*"))
                //.paths(regex("/filldb.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfo(
                "LeTour Microblog REST API",
                "Spring Boot REST API documentation",
                "1.0",
                "Terms of service",
                new Contact("Emmanuel Gomez Soler", "https://github.com/emmanuelgomez/redbee.microblog", "emmanuel.gomezsoler@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");

    }
}