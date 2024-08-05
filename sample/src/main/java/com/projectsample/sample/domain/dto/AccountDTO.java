package com.projectsample.sample.domain.dto;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    
// aca se hacen las validaciones antes de ir a la base de datos

    @Email( message =  "email is incorrectly formatted")
    @NotBlank (message = "email must not be empty")
    private String email;

    @NotBlank( message =  "password must not be empty")
    private String password;


    private Set<String> roles;


}
