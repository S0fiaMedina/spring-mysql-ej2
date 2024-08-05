package com.projectsample.sample.controllers;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@ResponseBody
@RequestMapping("/access")
public class AdminController {
    

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    // @PreAuthorize("hasAnyRole('ADMIN', 'USER')") -> Esto es para varios roles
    public String getMethodName() {
        return "GET:: ADMIN";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String postMethodName() {
        return "POST:: USER";
    }
    
}
