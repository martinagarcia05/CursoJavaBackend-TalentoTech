package com.techlab.demo.controller;

import org.springframework.web.bind.annotation.RestController;

//debe controlar lo que entra desde afuera:
@RestController
public class EstudioController {
//configuracion de los endpoints
    public String helloWorld(){
        return "Hello World desde spring boot";
    }
}
