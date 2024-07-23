package com.jsonspring.jsonandspring.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonspring.jsonandspring.models.Product;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;
    
    public ProductRepositoryJson(){
        ClassPathResource resource = new ClassPathResource("products.json"); // crea el path
        ObjectMapper objectMapper = new ObjectMapper(); // para serializar objetos

        try {
            list = Arrays.asList(
                objectMapper.readValue(resource.getFile(), Product[].class)
            );

        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }
    @Override
    public Product findById(Long id) {
        return list.stream().filter(p ->
        p.getId().equals(id)).findFirst().orElse(null);
    }
    
}
