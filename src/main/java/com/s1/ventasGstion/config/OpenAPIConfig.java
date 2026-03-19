package com.s1.ventasGstion.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API DOCUMENTADA DE GESTION DE VENTAS")
                        .version("1.0")
                        .description("Esta API, se construyó para la gestion de" +
                                " ventas en swagger."));
    }
}
