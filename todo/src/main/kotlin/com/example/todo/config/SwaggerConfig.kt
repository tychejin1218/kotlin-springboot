package com.example.todo.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

  @Bean
  fun publicApi(): GroupedOpenApi {
    return GroupedOpenApi.builder()
      .group("todo")
      .pathsToMatch("/api/**")
      .build();
  }

  @Bean
  fun springShopOpenAPI(): OpenAPI {
    return OpenAPI().info(
      Info()
        .title("TODO LIST")
        .description("TODO LIST WebApplication 만들기")
        .version("v0.0.1")
    )
  }
}