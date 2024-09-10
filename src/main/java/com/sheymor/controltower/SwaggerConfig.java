package com.sheymor.controltower;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Control Tower API")
                        .version("v1.0")
                        .description("Simple API for CV using Spring Boot")
                        .termsOfService("https://swagger.io/terms/")
                        .contact(new Contact().email("Joseacvz81@gmail.com").name("Jose Armando Coronel Vasquez"))
        );
    }
}
