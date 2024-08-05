package com.projectsample.sample.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectsample.sample.domain.entity.Role;
import com.projectsample.sample.domain.entity.RoleEnum;


import java.util.Optional;


public interface RoleRepository extends CrudRepository<Role, Long>{
    
    Optional<Role> findByName(RoleEnum name);
}
