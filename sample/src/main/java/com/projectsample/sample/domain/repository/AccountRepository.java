package com.projectsample.sample.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.projectsample.sample.domain.entity.Account;
import java.util.List;


public interface AccountRepository extends CrudRepository<Account, Long >{
    
    List<Account> findByEmail(String email);
    
}
