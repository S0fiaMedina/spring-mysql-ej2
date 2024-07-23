package com.jsonspring.jsonandspring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsonspring.jsonandspring.models.Product;
import com.jsonspring.jsonandspring.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product show(@PathVariable Long id){
        return productService.findById(id);
    }
    
}
