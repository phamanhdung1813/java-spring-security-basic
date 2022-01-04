package com.anhdungpham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "main.html";
    }

    @PostMapping("/doSth")
    @ResponseBody
//    @CrossOrigin("*")
    public String doSt() {
        System.out.println("DO SOMETHING");
        return "TESTING !!!";
    }
}
