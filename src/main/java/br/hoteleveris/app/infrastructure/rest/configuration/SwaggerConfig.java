package br.hoteleveris.app.infrastructure.rest.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.*;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.hoteleveris.app.controller"))
          .paths(PathSelectors.any())
          .build()
          .securitySchemes(Arrays.asList(apiKey()));
    }	
	
	private ApiKey apiKey() {
	    return new ApiKey("jwtToken", "Authorization", "header");
	}

}
