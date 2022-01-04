package com.anhdungpham.lau_ren_1.auth.token;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthToken {
    private List<String> myTokens = new ArrayList<>();

    public void add(String token) {
        myTokens.add(token);
    }

    public boolean check(String token) {
        return myTokens.contains(token);
    }
}
