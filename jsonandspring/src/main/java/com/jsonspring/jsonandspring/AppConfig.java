package com.jsonspring.jsonandspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jsonspring.jsonandspring.repositories.ProductRepository;
import com.jsonspring.jsonandspring.repositories.ProductRepositoryJson;


// esto es un bean ya que nos permite traer las variables del entorno
@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    @Bean("productJson")
    
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}

