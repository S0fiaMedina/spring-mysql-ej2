package com.projectsample.sample.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projectsample.sample.domain.entity.Account;


public interface AccountRepository extends CrudRepository<Account, Long >{
    
    List<Account> findByEmail(String email);
    
}
