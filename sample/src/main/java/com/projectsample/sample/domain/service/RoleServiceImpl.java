package com.projectsample.sample.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsample.sample.domain.entity.Role;
import com.projectsample.sample.domain.entity.RoleEnum;
import com.projectsample.sample.domain.repository.RoleRepository;

@Service
public class RoleServiceImpl {
    
    @Autowired
    private RoleRepository roleRepository;

    public Role getOrCreateRole(RoleEnum roleEnum) {
    // Busca el rol en la base de datos. Si no existe, lo crea.
        return roleRepository.findByName(roleEnum)
        .orElseGet( () -> {
            Role newRole = new Role();
            newRole.setName(roleEnum);
            return roleRepository.save(newRole);
        });               // Si no existe, crea un nuevo Role y configura el nombre
}

}
