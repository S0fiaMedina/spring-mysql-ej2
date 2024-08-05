package com.projectsample.sample.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectsample.sample.domain.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
    
}
