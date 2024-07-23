package com.javaexceptions.javaexceptions.controlador;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javaexceptions.javaexceptions.dominio.dto.Error;

@RestControllerAdvice // Manejo global de las excepciones

public class HandlerExceptionController {
    @ExceptionHandler({ArithmeticException.class}) // maneja el tipo de excepcion aitmetica (las llaves son por si quiero manrejar más excepciones)
    public ResponseEntity<Error> divisionByZero(Exception ex){

        Error error = new Error();
        error.setDate(new Date());
        error.setError("Division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());


        return error;
        
    }

}
