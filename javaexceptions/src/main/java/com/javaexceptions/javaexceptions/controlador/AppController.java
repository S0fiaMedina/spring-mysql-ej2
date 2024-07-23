package com.javaexceptions.javaexceptions.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    /*Aqui, por ejemplo se va a manejar el error de division por 0*/
    @GetMapping
    public Integer index(){
        int value = 100 /0;
        return value;

    }
}
