package com.projectsample.sample.domain.dto;

import java.util.Set;

import com.projectsample.sample.domain.entity.RoleEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public class AccountDTO {
    
    // aca se hacen las validaciones antes de ir a la base de datos

        @Email( message =  "email is incorrectly formatted")
        @NotBlank (message = "email must not be empty")
        private String email;

        @NotBlank( message =  "password must not be empty")
        private String password;


        private Set<RoleEnum> roles;

    public AccountDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> role) {
        this.roles = role;
    }  

    



    
}
