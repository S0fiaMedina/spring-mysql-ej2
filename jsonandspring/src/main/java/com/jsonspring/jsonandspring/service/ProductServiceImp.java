package com.jsonspring.jsonandspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jsonspring.jsonandspring.models.Product;
import com.jsonspring.jsonandspring.repositories.ProductRepository;
import com.jsonspring.jsonandspring.repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImp implements ProductService{
    
    private ProductRepository productRepository;

    @Value("${config.tax.price}")
    private double tax;

    @Autowired // inyecta el bean
    public void setproductRepository(@Qualifier("productJson")ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(){
        return productRepository.findAll().stream()
            .map(p -> {
                Double priceTax = p.getPrice() * tax;
                
                // Product newProduct = new Product(p.getId(), p.getName(), // hace que suba de precio         
                // priceImp.longValue());
                // p.setPrice(priceImp.longValue()); // lo pasa a long
                Product newProduct = (Product) p.clone(); // conversion explicita -> Mayor a menor
                newProduct.setPrice(priceTax.longValue());
                return newProduct;
            }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return productRepository.findById(id);
    }
}
