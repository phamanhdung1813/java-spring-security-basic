package com.anhdungpham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping
    public String main() {
        return "main.html";
    }

    @PostMapping("/doSth")
    public String doSt() {
        System.out.println("CSRF ATTACKING");
        return "main.html";
    }
}
