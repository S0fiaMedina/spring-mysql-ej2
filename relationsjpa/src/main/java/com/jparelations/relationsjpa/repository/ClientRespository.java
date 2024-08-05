package com.jparelations.relationsjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.jparelations.relationsjpa.models.Client;

public interface ClientRespository extends CrudRepository<Client, Long>{
    
}
