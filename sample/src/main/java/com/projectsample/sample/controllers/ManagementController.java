package com.projectsample.sample.controllers;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@ResponseBody
@RequestMapping("api/v1/manager")
public class ManagementController {
    

    @GetMapping()
    public String getMethodName() {
        return "GET:: MANAGER";
    }

    @PostMapping()
    public String postMethodName() {
        return "POST:: MANAGER";
    }

    @PutMapping()
    public String putMethodName() {
        return "PUT:: MANAGER";
    }


    @DeleteMapping()
    public String deleteMethodName() {
        return "DELETE:: MANAGER";
    }
    
}
