package com.feng.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName : Swagger3Config
 * @Description : Swagger3Config
 * @Author : 疯小瑞
 * @Date: 2023-01-06 09:20
 */
@Configuration
public class Swagger3Config {

    @Value("${spring.application.name}")
    private String serviceName;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(serviceName + " APIs")
                        .description(serviceName + "开放接口文档")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("swagger官方文档")
                        .url("https://swagger.io/docs/open-source-tools/swagger-ui/usage/configuration/"));

    }


}
