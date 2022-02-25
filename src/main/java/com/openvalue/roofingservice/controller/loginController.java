package com.openvalue.roofingservice.controller;

import com.openvalue.roofingservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public String test(@RequestParam(value = "code") String code){
        loginService.login(code);
        return "";
    }
}
