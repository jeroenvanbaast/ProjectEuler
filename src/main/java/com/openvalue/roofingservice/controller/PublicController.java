package com.openvalue.roofingservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PublicController {
    @GetMapping("/")
    public String homePage() {
        return "redirect:/swagger-ui.html";
    }
}
