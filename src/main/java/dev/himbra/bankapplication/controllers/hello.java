package dev.himbra.bankapplication.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Hidden
public class hello {
    @GetMapping("/hello")
    public String hello(){
        return "hello admin";
    }
}
