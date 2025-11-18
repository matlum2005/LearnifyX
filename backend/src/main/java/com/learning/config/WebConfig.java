package com.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                // Spring Boot 3+ me allowedOrigins("*") se error aata hai, isliye ye use karo:
                .allowedOriginPatterns("*")
                // allowed methods
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // sab headers allow kar do
                .allowedHeaders("*")
                // Postman aur frontend dono ke liye credentials optional rakho
                .allowCredentials(false);
    }
}
