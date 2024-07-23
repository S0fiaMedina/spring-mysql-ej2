package com.jsonspring.jsonandspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.jsonspring.jsonandspring.repositories.ProductRepository;
import com.jsonspring.jsonandspring.repositories.ProductRepositoryJson;

@Configuration
// @PropertySource("classpath:config.properties")
public class AppConfig {
    @Bean
    @Primary
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}

