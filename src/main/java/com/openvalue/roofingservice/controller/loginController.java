package com.openvalue.roofingservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/login")
public class loginController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/not-restricted")
    public String notRestricted() {
        return "you don't need to be logged in";
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/restricted")
    public String restricted() {
        return "if you see this you are logged in";
    }

}
