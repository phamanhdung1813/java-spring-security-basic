package com.anhdungpham.lau_ren.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomFilter extends UsernamePasswordAuthenticationToken {
    public CustomFilter(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public CustomFilter(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities, credentials, authorities);
    }
}
