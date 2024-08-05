package com.projectsample.sample.domain.repository;



import org.springframework.data.repository.CrudRepository;

import com.projectsample.sample.domain.entity.Permission;

public interface PermissionRepository extends CrudRepository<Permission, Long>{
    
}
