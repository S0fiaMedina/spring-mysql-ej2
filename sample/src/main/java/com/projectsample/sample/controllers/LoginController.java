package com.projectsample.sample.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectsample.sample.domain.dto.AccountDTO;
import com.projectsample.sample.domain.entity.Account;
import com.projectsample.sample.domain.entity.Role;
import com.projectsample.sample.domain.repository.AccountRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/ecommerce/welcome")
public class LoginController {
    

    @Autowired 
    private AccountRepository accountRepository;

    @Autowired // inyecta el bean de la configuracion de seguridad  
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    // @PreAuthorize("permitAll()")
    public String logInto() {
        return "Ingresa tu usuario y contraseña";
    }

    @PostMapping("/create-user")
    // @PreAuthorize("permitAll()")
    public ResponseEntity<?> createUser(@Valid @RequestBody AccountDTO accountDTO,
    BindingResult result) {
        System.out.println("aaaaaaaaaaaaaaaaa");
        // validacion de errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        // OBTENCION DE LOS ROLES
        Set<Role> roles = accountDTO.getRoles().stream()
        .map(roleName -> {
            Role role = new Role();
            role.setName(roleName); 
            return role;
        })
        .collect(Collectors.toSet());
        // creacion de un nuevo usuario

        // CREACION DE LA ENTIDAD 
        Account account = new Account();
        account.setEmail( accountDTO.getEmail());
        account.setPassword( accountDTO.getPassword());
        account.setIsActive( true);
        account.setPassword(
            passwordEncoder.encode( accountDTO.getPassword() ) // encripta la contraseña
            );
        account.setRoles( roles);

        

        return ResponseEntity.status(HttpStatus.CREATED)
            .body( this.accountRepository.save(account) );
        
    }
    

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " +
            err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
