package com.anhdungpham.controllers;

import com.anhdungpham.services.CustomService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    private final CustomService service;

    public DemoController(CustomService service) {
        this.service = service;
    }

    @GetMapping("/test1")
    public String test1() {
        return service.test1();
    }

    @GetMapping("/test2")
    public String test2() {
        return service.test2();
    }

    @GetMapping("/test3")
    public String test3() {
        return service.test3();
    }


    @GetMapping("/test4")
    public List<String> test4() {
        List<String> list = new ArrayList<>();
        list.add("user1");
        list.add("user2");
        list.add("user3");
        return service.test4(list);
    }

    @GetMapping("/test5")
    public List<String> test5() {
        List<String> list = List.of("user1","user2","user3"); // immutable object
//        List<String> list = new ArrayList<>();
//        list.add("user1");
//        list.add("user2");
//        list.add("user3");
        return service.test4(list);
    }

    @GetMapping("/test6")
    public List<String> test6() {
//        List<String> list = List.of("user1","user2","user3");
        List<String> list = new ArrayList<>();
        list.add("user1");
        list.add("user2");
        list.add("user3");
        return service.test5(list);
    }

}
