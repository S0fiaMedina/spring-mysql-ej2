package com.jsonspring.jsonandspring.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import com.jsonspring.jsonandspring.models.Product;

@SessionScope
@Primary
@Repository("productList") // para que spring asocie el repo con la implementacion
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> products;

    public ProductRepositoryImpl(){
        
        // definiendo lista de productos
        this.products = Arrays.asList(
            new Product(1L, "Laptop",  4500000L), 
            new Product(2L, "Smartphone",  2000000L), 
            new Product(3L, "Tablet",  1200000L), 
            new Product(4L, "Monitor", 800000L), 
            new Product(5L, "Keyboard",  1500001L), 
            new Product(6L, "Mouse", 80000L),
            new Product(7L, "Printer", 700000L),
            new Product( 8L, "External Hard Drive",  350000L),
            new Product(9L, "Headphones",  200000L),
            new Product(10L, "webcam", 250000L)
        );
    }

    @Override
    public List<Product> findAll(){
        return this.products;
    }

    @Override
    public Product findById(Long id){
        return this.products.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst().orElseThrow();
    }


}
