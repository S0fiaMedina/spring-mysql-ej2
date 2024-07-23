package com.jsonspring.jsonandspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsonspring.jsonandspring.models.Product;
import com.jsonspring.jsonandspring.repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImp implements ProductService{
    
    @Autowired
    private ProductRepositoryImpl productRepository;

    @Override
    public List<Product> findAll(){
        return productRepository.findAll().stream()
            .map(p -> {
                Double priceImp = p.getPrice() * 1.45d;
                
                // Product newProduct = new Product(p.getId(), p.getName(), // hace que suba de precio         
                // priceImp.longValue());
                // p.setPrice(priceImp.longValue()); // lo pasa a long
                Product newProduct = (Product) p.clone(); // conversion explicita -> Mayor a menor
                return newProduct;
            }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return productRepository.findById(id);
    }
}
