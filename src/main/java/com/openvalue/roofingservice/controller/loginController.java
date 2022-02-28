package com.openvalue.roofingservice.controller;

import com.openvalue.roofingservice.model.User;
import com.openvalue.roofingservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@RestController
@RequestMapping(path = "api/login")
public class loginController {

    private final LoginService loginService;

    @Autowired
    public loginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String helloWorld() {
        System.out.println("WERK");
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

    @PostMapping("/code")
    public ResponseEntity<User> test(@RequestParam(value = "code") String code) {
        Optional<User> optionalUser = loginService.login(code);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok().body(optionalUser.get());
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
    }
}
