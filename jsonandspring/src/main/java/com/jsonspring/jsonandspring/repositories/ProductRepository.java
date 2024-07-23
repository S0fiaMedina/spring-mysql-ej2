package com.jsonspring.jsonandspring.repositories;

import java.util.List;

import com.jsonspring.jsonandspring.models.Product;

public interface ProductRepository {

    public List<Product> findAll();

    public Product findById(Long id);
}
