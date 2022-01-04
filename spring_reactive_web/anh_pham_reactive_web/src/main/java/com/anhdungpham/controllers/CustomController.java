package com.anhdungpham.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CustomController {
    @GetMapping("/auth")
    @PreAuthorize("hasAuthority('read')")
    public Mono<String> hello() {
        Mono<Authentication> auth = ReactiveSecurityContextHolder.getContext().map(
                SecurityContext::getAuthentication
        );
        System.out.println(auth);
        return auth.map(i -> "Authenticate user: " + i.getName());
    }
}
