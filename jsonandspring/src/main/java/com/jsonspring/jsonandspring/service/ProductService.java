package com.jsonspring.jsonandspring.service;

import java.util.List;

import com.jsonspring.jsonandspring.models.Product;

public interface ProductService {

    
    public List<Product> findAll();

    public Product findById(Long id);

    
}
