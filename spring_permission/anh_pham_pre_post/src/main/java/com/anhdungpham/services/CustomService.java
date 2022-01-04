package com.anhdungpham.services;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomService {
    @PreAuthorize("hasAuthority('read')")
    public String test1() {
        System.out.println("TEST 1");
        return "TEST1";
    }

    @PostAuthorize("hasAuthority('read')")
    public String test2() {
        System.out.println("TEST 2");
        return "TEST2";
    }

    @PostAuthorize("returnObject == authentication.name")
    public String test3() {
        return "user1";
    }

    @PreFilter("filterObject != 'user1'")
    public List<String> test4(List<String> list) {
        return list;
    }

    @PostFilter("filterObject != 'user1'")
    public List<String> test5(List<String> list) {
        return list;
    }


}
