package com.projectsample.sample.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectsample.sample.domain.dto.AccountDTO;
import com.projectsample.sample.domain.entity.Account;
import com.projectsample.sample.domain.entity.Role;
import com.projectsample.sample.domain.entity.RoleEnum;
import com.projectsample.sample.domain.repository.AccountRepository;
import com.projectsample.sample.domain.service.RoleServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/ecommerce/welcome")
public class LoginController {
    

    @Autowired 
    private AccountRepository accountRepository;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

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

        // validacion de errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        

        // obtencion de roles
        Set<Role> roles = accountDTO.getRoles().stream()
        .map(role -> Role.builder()
            .name(RoleEnum.valueOf(role))
            .build())
            .collect(Collectors.toSet());

        // contruccion de accounbt
        Account account = Account.builder()
            .email(accountDTO.getEmail())
            .password( passwordEncoder.encode(accountDTO.getPassword() ) )
            .isActive( true)
            .roles(roles)
            .build();


        return ResponseEntity.status(HttpStatus.CREATED)
                .body( this.accountRepository.save(account) );

        // System.out.println("aaaaaaaaaaaaaaaaa");
        // // validacion de errores
        // if (result.hasFieldErrors()) {
        //     return validation(result);
        // }

        // // OBTENCION DE LOS ROLES
        // Set<Role> roles = accountDTO.getRoles().stream()
        // .map(roleName -> {
        //     Role role = new Role();
        //     role.setRoleEnum(roleName); 
        //     return role;
        // })
        // .collect(Collectors.toSet());
        // // creacion de un nuevo usuario

        // // CREACION DE LA ENTIDAD 
        // Account account = new Account();
        // account.setEmail( accountDTO.getEmail());
        // account.setPassword( accountDTO.getPassword());
        // account.setIsActive( true);
        // account.setPassword(
        //     passwordEncoder.encode( accountDTO.getPassword() ) // encripta la contraseña
        //     );
        // account.setRoles( roles);

        

       
        
    }

    @DeleteMapping("/delete-user")
    public String deleteUser(@RequestParam Long id){
        this.accountRepository.deleteById(id);
        return "Se ha borrado la cuenta con el id "+ id;
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
